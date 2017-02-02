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
public class OrderDAO {

	private JdbcTemplate jdbc;
	
	@Autowired
	private SenderDAO senderDAO;
	
	@Autowired
	private ReceiverDAO receiverDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insertOrder(Order order)
	{
		jdbc.update("INSERT INTO orders (id_sender, id_receiver, reception_date , delivery_date, id_worker, id_driver, weight, content) VALUES (?,?,?,?,?,?,?,?)",
				order.getSender().getId(), order.getReceiver().getId(), order.getReceptionDate(), order.getDeliveryDate(), order.getId_worker().getId(), order.getId_driver().getId(), order.getWeight(), order.getContent());
	}
	public List<Order> listOrder()
	{	
		String query = "SELECT * FROM Order";
		return jdbc.query(query, new RowMapper<Order>() {

			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order(rs.getString("id"), senderDAO.findById(rs.getString("id_sender")), receiverDAO.findById(rs.getString("id_receiver")), rs.getString("reception_date"),rs.getString("delivery_date"),userDAO.findById(rs.getInt("id_worker")),userDAO.findById(rs.getInt("zipcode")), rs.getString("weight"), rs.getString("content"));
				return order;
			}			
		});
	}
	
}
