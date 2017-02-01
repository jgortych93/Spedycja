package edu.zut.wi;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@NotEmpty @Size(max=20, message="Maksymalna długość to 20 znaków")
	private String marka;
	@NotEmpty @Size(max=20, message="Maksymalna długość to 20 znaków")
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
