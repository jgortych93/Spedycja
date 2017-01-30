package edu.zut.wi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SenderController {
	
	
	@RequestMapping(value = "sender/add")
	public String createSender(Model model)
	{
		return "home";
	}
}
