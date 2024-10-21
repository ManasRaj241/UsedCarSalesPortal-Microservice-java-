package com.Manas.UCSP.DTO;

import com.Manas.UCSP.Entity.Vehicles;

public class CartRequestDTO {

	private Vehicles vehicle;
	private String emailId;
	public Vehicles getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public CartRequestDTO(Vehicles vehicle, String emailId) {
		super();
		this.vehicle = vehicle;
		this.emailId = emailId;
	}
	public CartRequestDTO() {
		super();
	}
	
	
}
