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
public class ReceiverController {
	
	@Autowired
	private ReceiverService receiverService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReceiverController.class);
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/receiver/add", method=RequestMethod.GET)
	public String createReceiver(Model model)
	{
		Receiver receiver = new Receiver();
		
		model.addAttribute("receiverForm", receiver);
		return "add_receiver";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/receiver/add", method=RequestMethod.POST)
	public String handleCreateReceiver(@ModelAttribute("receiverForm") Receiver receiver, BindingResult result, Model model)
	{
		receiverService.addReceiver(receiver);
		return "redirect:/receivers";
	}
	
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/receivers", method=RequestMethod.GET)
	public String listReceivers(Model model)
	{
		model.addAttribute("receivers", receiverService.getAll());
		return "list_receivers";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/receiver/{id}/delete", method = RequestMethod.GET)
	public String deleteReceiver(@PathVariable("id") int id)
	{
		receiverService.deleteReceiver(Integer.toString(id));
		return "redirect:/receivers";
	}
	
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/receiver/{id}/update", method = RequestMethod.GET)
	public String updateReceiver(@PathVariable("id") int id, Model model)
	{
		Receiver receiver = receiverService.getReceiver(id);
		model.addAttribute("receiverForm", receiver);
		return "add_receiver";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/receiver/{id}/update", method = RequestMethod.POST)
	public String handleUpdateReceiver(@ModelAttribute("receiverForm") Receiver receiver, BindingResult result, Model model)
	{
		receiverService.updateReceiver(receiver);
		return "redirect:/receivers";
	}
	
}
