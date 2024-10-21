package com.CartService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CartService.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findByEmailId(String emailId);
	
	void deleteByEmailId(String emailId);
}
