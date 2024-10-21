package com.Manas.UCSP.DTO;

public class CartDTO {

	private int id;
	private String emailId;
	private int vehicleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public CartDTO(int id, String emailId, int vehicleId) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.vehicleId = vehicleId;
	}
	public CartDTO() {
		super();
	}
	
	
}
