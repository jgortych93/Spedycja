package edu.zut.wi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SenderController {
	
	@Autowired
	private SenderService senderService;
	
	private static final Logger logger = LoggerFactory.getLogger(SenderController.class);
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/sender/add", method=RequestMethod.GET)
	public String createSender(Model model)
	{
		Sender sender = new Sender();
		
		model.addAttribute("senderForm", sender);
		return "add_sender";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/sender/add", method=RequestMethod.POST)
	public String handleCreateSender(@ModelAttribute("senderForm") Sender sender, BindingResult result, Model model)
	{
		senderService.addSender(sender);
		return "redirect:/senders";
	}
	
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/senders", method=RequestMethod.GET)
	public String listSenders(Model model)
	{
		model.addAttribute("senders", senderService.getAll());
		return "list_senders";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/sender/{id}/delete", method = RequestMethod.GET)
	public String deleteSender(@PathVariable("id") int id)
	{
		senderService.deleteSender(Integer.toString(id));
		return "redirect:/senders";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/sender/{id}/update", method = RequestMethod.GET)
	public String updateSender(@PathVariable("id") int id, Model model)
	{
		Sender sender = senderService.getSender(id);
		model.addAttribute("userForm", sender);
		return "add_sender";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/sender/{id}/update", method = RequestMethod.POST)
	public String handleUpdateSender(@ModelAttribute("senderForm") Sender sender, BindingResult result, Model model)
	{
		senderService.updateSender(sender);
		return "redirect:/senders";
	}
	
}
