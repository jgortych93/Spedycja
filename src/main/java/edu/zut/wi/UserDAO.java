package edu.zut.wi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO {
	
private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	private static final class UserMapper implements RowMapper<User> {

		public  User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User User = new User(rs.getInt("id"),rs.getString("username"), rs.getString("password"), rs.getString("user_role"));
			return User;
		}	
	}

	
	public List<User> listUser()
	{	
		String query = "SELECT * FROM users";
		return jdbc.query(query, new UserMapper());			
		
	}
	
	void insertUser(User user)
	{
		jdbc.update("INSERT INTO users (username,password,user_role) VALUES (?,?,?)",user.getUsername(),user.getPassword(),user.getUser_role());	
	}
	
	void updateUser(User user)
	{
		jdbc.update("UPDATE users SET username=?, password=?, user_role=? WHERE id=?",user.getUsername(),user.getPassword(),user.getUser_role(),user.getId());
	}
	
	void deleteUser(int id)
	{
		jdbc.update("DELETE FROM users WHERE id=?", id);
	}
	
	public User findById(int id) {

		

		User result = null;
		try {
			result = jdbc.queryForObject("SELECT * FROM users WHERE id=?", new Object[]{new Integer(id)}, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return result;

	}

}
