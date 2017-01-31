package edu.zut.wi;

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
	
}
