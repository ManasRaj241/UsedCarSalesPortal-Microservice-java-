package com.CartService.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CartService.entity.Cart;
import com.CartService.entity.DTO.CheckoutDTO;
import com.CartService.entity.DTO.VehiclesDTO;
import com.CartService.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository repository;

	public Cart AddToCart(Cart cart) {
		return repository.save(cart);
	}

	public List<Cart> retrieveCartDetailsByEmailId(String emailId) {
		return repository.findByEmailId(emailId);
	}

	public int deleteCartDetailsByCartId(int cartId) {
		Optional<Cart> existingCart = repository.findById(cartId);
		if (existingCart.isPresent()) {
			repository.deleteById(cartId);
			return cartId;
		}
		return -1;
	}
	
	@Transactional
	public void deleteCartDetailsByEmailId(String emailId) {
        repository.deleteByEmailId(emailId);
    }
	
	public List<Integer> getVehicleIdsFromCart(List<Cart> cart){
		List<Integer> allVehicleIds = new ArrayList<Integer>();
		for(Cart c : cart) {
			allVehicleIds.add(c.getVehicleId());
		}
		return allVehicleIds;
	}

	public CheckoutDTO prepareCheckoutObjFromCart(List<Cart> cart, List<VehiclesDTO> vehicles) {
		if(cart.size() == 0) return null;
		CheckoutDTO obj = new CheckoutDTO();
		obj.setCouponApplied(false);
		obj.setDiscountAmount(0);
		obj.setEmailId(cart.get(0).getEmailId());
		int finalAmount = 0;
		List<Integer> cardIdList = new ArrayList<Integer>();
		for(Cart c : cart) {
			cardIdList.add(c.getId());
		}
		for(VehiclesDTO vehicle : vehicles) {
			finalAmount += vehicle.getPrice();
		}
		obj.setTotalAmount(finalAmount);
		obj.setFinalAmount(finalAmount);
		obj.setCartIds(cardIdList);
		return obj;
	}

}
