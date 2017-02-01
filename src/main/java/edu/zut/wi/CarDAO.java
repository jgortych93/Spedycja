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
public class CarDAO {

	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	private static final class CarMapper implements RowMapper<Car> {

		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			Car car = new Car(rs.getInt("id"), rs.getString("marka"), rs.getString("model"), rs.getInt("pojemnosc"),rs.getBoolean("status"));
			return car;
		}	
	}

	
	public List<Car> listCar()
	{	
		String query = "SELECT * FROM cars";
		return jdbc.query(query, new CarMapper());			
		
	}
	
	void insertCar(Car auto)
	{
		jdbc.update("INSERT INTO cars (marka,model,pojemnosc) VALUES (?,?,?)",auto.getMarka(),auto.getModel(),auto.getPojemnosc());	
	}
	
	void updateCar(Car auto)
	{
		jdbc.update("UPDATE cars SET marka=?, model=?, pojemnosc=? WHERE id=?",auto.getMarka(),auto.getModel(),auto.getPojemnosc(),auto.getId());
	}
	
	
	
	public Car findById(int id) {

		

		Car result = null;
		try {
			result = jdbc.queryForObject("SELECT * FROM cars WHERE id=?", new Object[]{new Integer(id)}, new CarMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return result;

	}
	
	void takeCar(Car auto)
	{
		jdbc.update("UPDATE cars SET status=1 WHERE id=?",auto.getId());
	}
	
	void returnCar(Car auto)
	{
		jdbc.update("UPDATE cars SET status=0 WHERE id=?",auto.getId());
	}
}
