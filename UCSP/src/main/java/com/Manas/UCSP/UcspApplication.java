package com.Manas.UCSP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Vehicle API", version = "1.0", description = "All The Vehicle APIs"))
@EnableDiscoveryClient
@EnableFeignClients
public class UcspApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcspApplication.class, args);
	}

}
