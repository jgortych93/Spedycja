package edu.zut.wi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

	@Autowired
	private SenderDAO senderDAO;
	
	public void addSender(Sender sender)
	{
		senderDAO.intertSender(sender.getName(), sender.getStreet(), sender.getNumber(), sender.getCity(),
				sender.getState(), sender.getZipCode());
	}
	
	
}
