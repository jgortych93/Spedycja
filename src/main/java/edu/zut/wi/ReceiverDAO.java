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
public class ReceiverDAO {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	private static final class ReceiverMapper implements RowMapper<Receiver>
	{
		public Receiver mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Receiver receiver = new Receiver(rs.getString("id"), rs.getString("name"), rs.getString("name"), rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zipcode"));
			return receiver;
		}
	}
	
	public List<Receiver> listReceiver()
	{	
		String query = "SELECT * FROM receiver";
		return jdbc.query(query, new RowMapper<Receiver>() {

			public Receiver mapRow(ResultSet rs, int rowNum) throws SQLException {
				Receiver Receiver = new Receiver(rs.getString("id"), rs.getString("name"), rs.getString("name"), rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zipcode"));
				return Receiver;
			}			
		});
	}
	
	public void intertReceiver(String name,String street,String number,String city,String state,String zipcode)
	{
		
		jdbc.update("INSERT INTO receiver (name,street,number,city,state,zipcode) VALUES (?,?,?,?,?,?)", name,street, number,city, state, zipcode);
	}

	public void deleteReceiver(String id)
	{
		jdbc.update("DELETE FROM receiver WHERE id=?", id);
	}
	
	public Receiver findById(String id)
	{
		return jdbc.queryForObject("SELECT * FROM receiver WHERE id=" + id, new ReceiverMapper());
	}
	
	public void updateReceiver(String id, String name,String street,String number,String city,String state,String zipcode)
	{
		jdbc.update("UPDATE receiver SET name = ?,street=?,number=?,city=?,state=?,zipcode=? WHERE id=?", name,street, number,city, state, zipcode,id);
	}
	
}
