package edu.zut.wi;

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
}
