package edu.zut.wi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SenderController {
	
	@Autowired
	private SenderService senderService;
	
	private static final Logger logger = LoggerFactory.getLogger(SenderController.class);
	
	@RequestMapping(value = "/sender/add", method=RequestMethod.GET)
	public String createSender(Model model)
	{
		Sender sender = new Sender();
		
		model.addAttribute("senderForm", sender);
		return "add_sender";
	}
	
	@RequestMapping(value = "/sender/add", method=RequestMethod.POST)
	public String handleCreateOrUpdateSender(@ModelAttribute("senderForm") Sender sender, BindingResult result, Model model)
	{
		senderService.addSender(sender);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/sender", method=RequestMethod.GET)
	public String listSenders(Model model)
	{
		model.addAttribute("senders", senderService.getAll());
		return "list_senders";
	}
	

	
	
}
