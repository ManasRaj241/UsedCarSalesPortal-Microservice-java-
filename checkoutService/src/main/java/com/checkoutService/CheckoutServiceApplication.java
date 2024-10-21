package com.checkoutService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Checkout API", version = "1.0", description = "All The Checkout APIs"))
public class CheckoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutServiceApplication.class, args);
	}

}
