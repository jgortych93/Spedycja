package edu.zut.wi;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class User {

	@NotEmpty @Size(min=3,max=20,message="Minimalna ilosc znakow 3, maksymalna 20")
	private String username;
	@NotEmpty @Size(min=3,max=20,message="Minimalna ilosc znakow 3, maksymalna 20")
	private String password;
	
	private String user_role;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User()
	{
		
	}
	public User(int id,String username,String password,String user_role)
	{
		this.username=username;
		this.password=password;
		this.user_role=user_role;
		this.id=id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
}
