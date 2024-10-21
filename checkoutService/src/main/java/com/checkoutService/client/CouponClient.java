package com.checkoutService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CouponService", path = "/CouponAPI/coupon")
public interface CouponClient {

	@GetMapping("/couponValidity")
    public Object findCoupon(@RequestParam String couponCode);
}
