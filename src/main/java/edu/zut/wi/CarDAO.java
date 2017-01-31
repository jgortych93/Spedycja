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
public class CarDAO {

	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public List<Car> listCar()
	{	
		String query = "SELECT * FROM cars";
		return jdbc.query(query, new RowMapper<Car>() {

			public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
				Car car = new Car(rs.getInt("id"), rs.getString("marka"), rs.getString("model"), rs.getInt("pojemnosc"),rs.getBoolean("status"));
				return car;
			}			
		});
	}
	
	void insertCar(Car auto)
	{
		jdbc.update("INSERT INTO cars (marka,model,pojemnosc) VALUES (?,?,?)",auto.getMarka(),auto.getModel(),auto.getPojemnosc());	
	}
	
	void updateCar(Car auto)
	{
		jdbc.update("UPDATE cars SET marka=?, model=?, pojemnosc=?, WHERE id=?",auto.getMarka(),auto.getModel(),auto.getPojemnosc(),auto.getId());
	}
	
}
