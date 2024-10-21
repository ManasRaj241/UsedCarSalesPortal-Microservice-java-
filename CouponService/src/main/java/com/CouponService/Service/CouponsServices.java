package com.CouponService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CouponService.Entity.Coupon;
import com.CouponService.Repository.CouponRepository;

@Service
public class CouponsServices {

	@Autowired
	private CouponRepository repository;
	
	public Coupon addNewCoupon(Coupon coupon) {
		return repository.save(coupon);
	}
	
	public Object findCouponByCode(String couponCode) {
        Optional<Coupon> coupon = repository.findByCouponCode(couponCode);
        if(coupon.isPresent()) return coupon;
        return "Coupon not present";
    }
	
	public List<Coupon> getAllCoupons() {
        return repository.findAll();
	}
    public String deleteCouponById(int couponId) {
        if (repository.existsById(couponId)) {
            repository.deleteById(couponId);
            return "Coupon deleted successfully";
        } else {
            return "Coupon not found";
        }
    }

    
    public Optional<Coupon> getCouponById(int couponId) {
        return repository.findById(couponId);
    }
    
    public Object updateCouponById(int couponId, Coupon updatedCoupon) {
        Optional<Coupon> existingCoupon = repository.findById(couponId);
        
        if (existingCoupon.isPresent()) {
            Coupon coupon = existingCoupon.get();
            coupon.setCouponCode(updatedCoupon.getCouponCode());
            coupon.setDiscountAmount(updatedCoupon.getDiscountAmount());
            coupon.setMinAmount(updatedCoupon.getMinAmount());
            repository.save(coupon);
            return coupon;
        } else {
            return "Coupon not found";
        }
    }

}
