package com.CartService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.CartService.client.CheckoutClient;
import com.CartService.client.VehiclesClient;
import com.CartService.entity.Cart;
import com.CartService.entity.DTO.CheckoutDTO;
import com.CartService.entity.DTO.VehiclesDTO;
import com.CartService.services.CartService;

@RestController
@RequestMapping("/CartAPI/Cart")
public class CartController {

	@Autowired
	private CartService service;
	
	@Autowired
	private VehiclesClient client;
	
	@Autowired
	private CheckoutClient checkoutClient;
	
	@PostMapping("AddToCart")
	public Cart addToCart(@RequestBody Cart cart) {
		return service.AddToCart(cart);
	}
	
	@RequestMapping(value="/{emailId}", method= RequestMethod.GET)
	public ResponseEntity<List<Cart>> retrieveVehicleModelById(@PathVariable String emailId) {
		List<Cart> cartDetails = service.retrieveCartDetailsByEmailId(emailId);
		if(cartDetails.size() == 0|| cartDetails == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cartDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{cartId}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCartDetailsByCartId(@PathVariable int cartId) {
		return service.deleteCartDetailsByCartId(cartId) != -1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete/{emailId}")
    public void deleteCartDetailsByEmailId(@PathVariable String emailId) {
        service.deleteCartDetailsByEmailId(emailId);
    }
	
	
	/*
	 * 
	 * Calling Cart Service using feign client
	 * 
	 */
	
	@RequestMapping(value="/getAllVehicles", method= RequestMethod.GET)
	public List<VehiclesDTO> GetAllVehicles(){
		return client.getAllVehicles().getBody();
	}
	
	@GetMapping("/getVehiclesByVehicleId")
    public ResponseEntity<List<VehiclesDTO>> getVehicleDetails(@RequestParam List<Integer> ids) {
        return client.getVehiclesByIds(ids);
    }
	
	/*
	 * 
	 * Calling Cart Service using feign client
	 * 
	 */
	
	/*
	 * =========================================================
	 * Calling Checkout service using Feign Client
	 * =========================================================
	 */
	
	@PostMapping("AddToCheckout")
	public ResponseEntity<CheckoutDTO> addToCheckout(@RequestBody List<Cart> cart) {
		List<Integer> vehicleIds = service.getVehicleIdsFromCart(cart);
		List<VehiclesDTO> vehicles = client.getVehiclesByIds(vehicleIds).getBody();
		CheckoutDTO checkoutObj = service.prepareCheckoutObjFromCart(cart, vehicles);
		if (checkoutObj == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return checkoutClient.addToCheckout(checkoutObj);
	}
	
	/*
	 * =========================================================
	 * Calling Checkout service using Feign Client
	 * =========================================================
	 */
}
