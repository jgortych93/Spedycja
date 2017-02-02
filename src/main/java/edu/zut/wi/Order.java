package edu.zut.wi;

public class Order {
	private String id;
	private Sender sender;
	private Receiver receiver;
	private String receptionDate;
	private String deliveryDate;
	private User id_worker;
	private User id_driver;
	private String weight;
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Sender getSender() {
		return sender;
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	public Receiver getReceiver() {
		return receiver;
	}
	public Order(String id, Sender sender, Receiver receiver, String receptionDate, String deliveryDate,
			User id_worker, User id_driver, String weight, String content) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.receptionDate = receptionDate;
		this.deliveryDate = deliveryDate;
		this.id_worker = id_worker;
		this.id_driver = id_driver;
		this.weight = weight;
		this.content = content;
	}
	
	public Order()
	{
		
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	public String getReceptionDate() {
		return receptionDate;
	}
	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public User getId_worker() {
		return id_worker;
	}
	public void setId_worker(User id_worker) {
		this.id_worker = id_worker;
	}
	public User getId_driver() {
		return id_driver;
	}
	public void setId_driver(User id_driver) {
		this.id_driver = id_driver;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
