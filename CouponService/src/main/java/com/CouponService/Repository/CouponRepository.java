package com.CouponService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CouponService.Entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	Optional<Coupon> findByCouponCode(String couponCode);
}
