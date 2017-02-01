package edu.zut.wi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverService {

	@Autowired
	private ReceiverDAO receiverDAO;
	
	public void addReceiver(Receiver receiver)
	{
		receiverDAO.intertReceiver(receiver.getName(), receiver.getStreet(), receiver.getNumber(), receiver.getCity(),
				receiver.getState(), receiver.getZipCode());
	}
	
	
	public List<Receiver> getAll()
	{
		return receiverDAO.listReceiver();
	}
	
	public void deleteReceiver(String id)
	{
		receiverDAO.deleteReceiver(id);
	}
	
	public Receiver getReceiver(int id)
	{

		return receiverDAO.findById(Integer.toString(id));
	}
	public void updateReceiver(Receiver receiver)
	{
		receiverDAO.updateReceiver(receiver.getId(), receiver.getName(), receiver.getStreet(), receiver.getNumber(), receiver.getCity(),
				receiver.getState(), receiver.getZipCode());
	}
}
