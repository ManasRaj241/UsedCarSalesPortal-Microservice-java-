package com.checkoutService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkoutService.client.CouponClient;
import com.checkoutService.entity.Checkout;
import com.checkoutService.services.CheckoutAPIService;

@RestController
@RequestMapping("/CheckoutAPI")
public class CheckoutController {

	@Autowired
	private CheckoutAPIService service;
	
	@Autowired
	private CouponClient client;
	
	@PostMapping("/AddToCheckout")
	public ResponseEntity<Checkout> addToCheckout(@RequestBody Checkout checkout) {
		return new ResponseEntity<>(service.AddToCheckout(checkout), HttpStatus.OK);
	}
	
	@GetMapping("/getCheckoutDetails/{emailId}")
	public Checkout getCheckoutDetailsForEmailId(@PathVariable String emailId) {
		return service.retrieveCheckoutDetailsByEmailId(emailId).get();
	}
	
	@PostMapping("/applyCoupon")
	public Checkout applyCouponIfValid(@RequestParam String coupon, @RequestBody Checkout checkout) {
		Object response = client.findCoupon(coupon);
		Checkout finalCheckoutValue = service.prepareFinalCheckoutValue(checkout, response);
		return finalCheckoutValue;
	}
	
}
