package edu.zut.wi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	private CarDAO carDAO;
	
	void addCar(Car car)
	{
		carDAO.insertCar(car);
	}
	
	void updateCar(Car car)
	{
		carDAO.updateCar(car);
	}
	
	public List<Car> getCars()
	{
		
		return carDAO.listCar();
	}
}
