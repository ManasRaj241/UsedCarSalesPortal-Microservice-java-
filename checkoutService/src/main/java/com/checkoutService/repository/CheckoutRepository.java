package com.checkoutService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkoutService.entity.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {

	Optional<Checkout> findByEmailId(String emailId);
	
	void deleteByEmailId(String emailId);
}
