package com.CouponService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CouponService.Entity.Coupon;
import com.CouponService.Service.CouponsServices;

@RestController
@RequestMapping("/CouponAPI/coupon")
public class CouponController {

	@Autowired
	private CouponsServices service;
	
	@PostMapping("AddNewCoupon")
	public Coupon addToCart(@RequestBody Coupon coupon) {
		return service.addNewCoupon(coupon);
	}
	
	@GetMapping("/couponValidity")
    public Object findCoupon(@RequestParam String couponCode) {
        return service.findCouponByCode(couponCode);
    }
	
	@PutMapping("/updateCoupon/{couponId}")
	public Object updateCoupon(@PathVariable int couponId, @RequestBody Coupon updatedCoupon) {
	    return service.updateCouponById(couponId, updatedCoupon);
	}
	
	@GetMapping
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        List<Coupon> coupons = service.getAllCoupons();
        return new ResponseEntity<>(coupons, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCouponById(@PathVariable int id) {
        service.deleteCouponById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Optional<Coupon>> getCouponById(@PathVariable int id) {
        Optional<Coupon> coupon = service.getCouponById(id);
        if (coupon.isPresent()) {
            return new ResponseEntity<>(coupon, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
