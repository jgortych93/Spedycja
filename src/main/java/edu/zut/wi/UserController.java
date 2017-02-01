package edu.zut.wi;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="users",method=RequestMethod.GET)
	public String listUsers(Model model)
	{
		model.addAttribute("users", userService.listUser());
		return "list_users";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String createUser(Model model)
	{
		User user = new User();
		model.addAttribute("userForm",user);
		return "add_user";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/user/add", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model)
	{
		if (result.hasErrors())
			return "add_user";
			
		userService.addUser(user);
		return "redirect:/users";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/user/{id}/update", method=RequestMethod.POST)
	public String handleCreateUser(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model)
	{
		if (result.hasErrors())
			return "add_user";
			
		
		userService.updateUser(user);
		return "redirect:/users";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/user/{id}/update", method=RequestMethod.GET)
	public String editUser(Model model,@PathVariable("id") int id)
	{
		User user = userService.findById(id);
		model.addAttribute("userForm",user);
		return "add_user";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/user/{id}/delete", method=RequestMethod.GET)
	public String deleteUser(Model model,@PathVariable("id") int id)
	{
		userService.deleteUser(id);
		return "redirect:/users";
	}

}
