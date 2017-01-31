package edu.zut.wi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {

	@Autowired 
	private CarService carService;
	
	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@RequestMapping(value="/car/add", method=RequestMethod.GET)
	public String createCar(Model model)
	{
		Car car = new Car();
		model.addAttribute("carForm",car);
		return "add_car";
	}
	
	@RequestMapping(value = "/car/add", method=RequestMethod.POST)
	public String handleCreateCar(@ModelAttribute("carForm") Car car, BindingResult result, Model model)
	{
		logger.info("Wprowadzo pojazd {}.", car.getMarka(),car.getModel());
		carService.addCar(car);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/car", method=RequestMethod.GET)
	public String listCars(Model model)
	{
		return "list_cars";
	}
}
