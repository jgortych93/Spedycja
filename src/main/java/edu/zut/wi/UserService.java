package edu.zut.wi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	List<User> listUser()
	{
		return userDAO.listUser();
	}
	
	void addUser(User user)
	{
		userDAO.insertUser(user);
		
		
	}
	void updateUser(User user)
	{
		userDAO.updateUser(user);
	}
	
	User findById(int id)
	{
		return userDAO.findById(id);
	}
	
	void deleteUser(int id)
	{
		userDAO.deleteUser(id);
	}
	
	List<User> getAllDrivers()
	{
		List<User> driverNames = new ArrayList<User>();
		List<User> users = listUser();
		for(User user: users)
			if(user.getUser_role().equals("ROLE_DRIVER"))
				driverNames.add(user);
		
		return driverNames;
	}
	
	User findByUsername(String name)
	{
		return userDAO.findByUsername(name);
	}
}
