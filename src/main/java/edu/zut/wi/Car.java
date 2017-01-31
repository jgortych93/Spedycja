package edu.zut.wi;

import org.springframework.stereotype.Component;

@Component
public class Car {
	
	private String marka;
	private String model;
	private int pojemnosc;
	private boolean status;
	private int id;
	
	public Car()
	{
		
	}
	
	public Car(int id,String marka,String model,int pojemnosc,boolean status)
	{
		this.id=id;
		this.marka=marka;
		this.model=model;
		this.pojemnosc=pojemnosc;
		this.status=status;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPojemnosc() {
		return pojemnosc;
	}

	public void setPojemnosc(int pojemnosc) {
		this.pojemnosc = pojemnosc;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
