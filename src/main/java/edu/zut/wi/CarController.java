package edu.zut.wi;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CarController {

	@Autowired 
	private CarService carService;
	
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/car/add", method=RequestMethod.GET)
	public String createCar(Model model)
	{
		Car car = new Car();
		model.addAttribute("carForm",car);
		return "add_car";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/car/{id}/update", method=RequestMethod.GET)
	public String editCar(Model model,@PathVariable("id") int id)
	{
		Car car = carService.findById(id);
		model.addAttribute("carForm",car);
		return "add_car";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/car/{id}/delete", method=RequestMethod.GET)
	public String deleteCar(Model model,@PathVariable("id") int id)
	{
		carService.deleteCar(id);
		return "redirect:/cars";
	}
	
	@Secured({"ROLE_USER","ROLE_DRIVER"})
	@RequestMapping(value="/cars", method=RequestMethod.GET)
	public String listCar(Model model)
	{
		model.addAttribute("cars",carService.getCars());
		return "list_cars";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/car/add", method=RequestMethod.POST)
	public String updateCar(@ModelAttribute("carForm") @Valid Car car, BindingResult result, Model model)
	{
		if (result.hasErrors())
			return "add_car";
			
		carService.addCar(car);
		return "redirect:/cars";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/car/{id}/update", method=RequestMethod.POST)
	public String handleCreateCar(@ModelAttribute("carForm") @Valid Car car, BindingResult result, Model model)
	{
		if (result.hasErrors())
			return "add_car";
			
		
		carService.updateCar(car);
		return "redirect:/cars";
	}
	
	@Secured("ROLE_DRIVER")
	@RequestMapping(value="car/take", method=RequestMethod.GET)
	public String takeCar(Model model)
	{
		return "redirect:/cars";
	}
	
	@Secured("ROLE_DRIVER")
	@RequestMapping(value="car/{id}/take", method=RequestMethod.GET)
	public String takingCar(Model model,@PathVariable("id") int id)
	{
		Car car = carService.findById(id);
		if (!car.isStatus())
			carService.takeCar(car);
		else
			return "take_fail";
		return "redirect:/cars";
	}
	
	@Secured("ROLE_DRIVER")
	@RequestMapping(value="car/{id}/return", method=RequestMethod.GET)
	public String returningCar(Model model,@PathVariable("id") int id)
	{
		Car car = carService.findById(id);
		if (car.isStatus())
			carService.returnCar(car);
		else
			return "return_fail";
		return "redirect:/cars";
	}
}
