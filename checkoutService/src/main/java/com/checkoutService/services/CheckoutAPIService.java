package com.checkoutService.services;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checkoutService.entity.Checkout;
import com.checkoutService.entity.DTO.CouponDTO;
import com.checkoutService.repository.CheckoutRepository;

@Service
public class CheckoutAPIService {

	@Autowired
	private CheckoutRepository repository;

	@Transactional
	public Checkout AddToCheckout(Checkout checkout) {
		Optional<Checkout> checkedInData = retrieveCheckoutDetailsByEmailId(checkout.getEmailId());
		if (checkedInData.isPresent() && checkout.getTotalAmount() != checkedInData.get().getTotalAmount()) {
			deleteCheckoutDetailsByEmailId(checkout.getEmailId());
			return repository.save(checkout);
		}else if(checkedInData.isPresent() && checkout.getTotalAmount() == checkedInData.get().getTotalAmount()) {
			return checkout;
		}
		return repository.save(checkout);
	}

	public Optional<Checkout> retrieveCheckoutDetailsByEmailId(String emailId) {
		return repository.findByEmailId(emailId);
	}

	@Transactional
	public void deleteCheckoutDetailsByEmailId(String emailId) {
		repository.deleteByEmailId(emailId);
	}

	public Checkout prepareFinalCheckoutValue(Checkout checkout, Object response) {
	    if (response instanceof Map) {
	        Map<?, ?> responseMap = (Map<?, ?>) response;
	        CouponDTO couponResponse = mapToCouponDTO(responseMap);
	        if (checkout.getTotalAmount() > couponResponse.getMinAmount() && !checkout.isCouponApplied()) {
	            checkout.setCouponApplied(true);
	            checkout.setDiscountAmount(couponResponse.getDiscountAmount());
	            checkout.setFinalAmount(checkout.getTotalAmount() - couponResponse.getDiscountAmount());
	            repository.save(checkout);
	        }
	    }
	    return checkout;
	}

	private CouponDTO mapToCouponDTO(Map<?, ?> map) {
	    CouponDTO couponDTO = new CouponDTO();
	    couponDTO.setCouponId((Integer) map.get("couponId"));
	    couponDTO.setCouponCode((String) map.get("couponCode"));
	    couponDTO.setDiscountAmount((Integer) map.get("discountAmount"));
	    couponDTO.setMinAmount((Integer) map.get("minAmount"));
	    return couponDTO;
	}
}
