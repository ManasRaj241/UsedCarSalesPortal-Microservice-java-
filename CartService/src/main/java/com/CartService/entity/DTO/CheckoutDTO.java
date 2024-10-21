package com.CartService.entity.DTO;

import java.util.List;

public class CheckoutDTO {

	private int id;
	private String emailId;
	private int totalAmount;
	private boolean isCouponApplied;
	private int discountAmount;
	private int finalAmount;
	private List<Integer> cartIds;
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
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isCouponApplied() {
		return isCouponApplied;
	}
	public void setCouponApplied(boolean isCouponApplied) {
		this.isCouponApplied = isCouponApplied;
	}
	public int getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}
	public int getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
	}
	public List<Integer> getCartIds() {
		return cartIds;
	}
	public void setCartIds(List<Integer> cartIds) {
		this.cartIds = cartIds;
	}
	public CheckoutDTO(int id, String emailId, int totalAmount, boolean isCouponApplied, int discountAmount,
			int finalAmount, List<Integer> cartIds) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.totalAmount = totalAmount;
		this.isCouponApplied = isCouponApplied;
		this.discountAmount = discountAmount;
		this.finalAmount = finalAmount;
		this.cartIds = cartIds;
	}
	public CheckoutDTO() {
		super();
	}
	
	
}
