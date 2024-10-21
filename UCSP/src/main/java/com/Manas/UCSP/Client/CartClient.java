package com.Manas.UCSP.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Manas.UCSP.DTO.CartDTO;


@FeignClient(name = "CartService", path = "/CartAPI/Cart")
public interface CartClient {

	@PostMapping("AddToCart")
	public CartDTO addToCart(@RequestBody CartDTO cart);
}
