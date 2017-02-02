package edu.zut.wi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ReceiverDAO receiverDAO;
	
	@Autowired
	private SenderDAO senderDAO;
	
	public void addOrder(Order order)
	{
		order.setId_driver(userDAO.findByUsername(order.getId_driver().getUsername()));
		order.setReceiver(receiverDAO.findByName(order.getReceiver().getName()));
		order.setSender(senderDAO.findByName(order.getSender().getName()));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		order.setReceptionDate(localDate.toString());
		orderDAO.insertOrder(order);
	}
	
	public List<Order> listOrders()
	{
		return orderDAO.listOrder();
	}
}
