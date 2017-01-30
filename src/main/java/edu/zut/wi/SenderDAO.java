package edu.zut.wi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SenderDAO {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public List<Sender> listSender()
	{	
		String query = "SELECT * FROM Sender";
		return jdbc.query(query, new RowMapper<Sender>() {

			public Sender mapRow(ResultSet rs, int rowNum) throws SQLException {
				Sender sender = new Sender(rs.getString("id"), rs.getString("name"), rs.getString("name"), rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zipcode"));
				return sender;
			}			
		});
	}
	
	public void intertSender(String name,String street,String number,String city,String state,String zipcode)
	{
		jdbc.update("INSERT INTO sender (name,street,number,city,state,zipcode) VALUES (?,?,?,?,?,?)", name,street, number,city, state, zipcode);
	}

	
	

	
}
