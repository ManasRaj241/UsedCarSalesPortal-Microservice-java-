package com.CartService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CartService.entity.DTO.CheckoutDTO;

@FeignClient(name = "checkoutService", path = "/CheckoutAPI")
public interface CheckoutClient {

	@PostMapping("/AddToCheckout")
	public ResponseEntity<CheckoutDTO> addToCheckout(@RequestBody CheckoutDTO checkout);
}
