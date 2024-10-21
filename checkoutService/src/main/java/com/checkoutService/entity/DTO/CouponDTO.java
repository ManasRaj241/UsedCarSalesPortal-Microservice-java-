package com.checkoutService.entity.DTO;

public class CouponDTO {

	private int couponId;
	private String couponCode;
	private int discountAmount;
	private int minAmount;
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}
	public int getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}
	public CouponDTO(int couponId, String couponCode, int discountAmount, int minAmount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.discountAmount = discountAmount;
		this.minAmount = minAmount;
	}
	public CouponDTO() {
		super();
	}
}
