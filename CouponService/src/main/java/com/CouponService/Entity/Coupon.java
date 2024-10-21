package com.CouponService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coupon_details")
public class Coupon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int couponId;
	private String couponCode;
	private int discountAmount;
	private int minAmount;
	public Coupon(int couponId, String couponCode, int discountAmount, int minAmount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.discountAmount = discountAmount;
		this.minAmount = minAmount;
	}
	public Coupon() {
		super();
	}
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
	
}
