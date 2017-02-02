package edu.zut.wi;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SenderService senderService;
	
	@Autowired
	private ReceiverService receiverService;
	
	@Autowired
	private UserService userService;
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/order/add", method=RequestMethod.GET)
	public String createOrder(Model model)
	{
		Order order = new Order();
		model.addAttribute("orderForm", order);
		addToModel(model);

		return "add_order";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/order/add", method=RequestMethod.POST)
	public String handleCreateOrder(@ModelAttribute("orderForm") Order order, BindingResult result, Model model, Principal principal)
	{
		order.setId_worker(userService.findByUsername(principal.getName()));
		orderService.addOrder(order);
		
		return "redirect:/orders";
	}
	
	private void addToModel(Model model)
	{
		List<String> senderNameList = new ArrayList<String>();
		List<Sender> senderList = senderService.getAll();
		for(Sender sender: senderList)
			senderNameList.add(sender.getName());
		model.addAttribute("senderName", senderNameList);		
		
		List<String> receiverNameList = new ArrayList<String>();
		List<Receiver> receiverList = receiverService.getAll();
		for(Receiver receiver: receiverList)
			receiverNameList.add(receiver.getName());
		model.addAttribute("receiverName", receiverNameList);		
		
		List<String> userNameList = new ArrayList<String>();
		List<User> userList = userService.getAllDrivers();
		for(User user: userList)
			userNameList.add(user.getUsername());
		model.addAttribute("userName", userNameList);	
	}
	
}
