package com.CartService.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CartService.entity.DTO.VehiclesDTO;

@FeignClient(name = "UCSP", path = "/VehicleService/Vehicles")
public interface VehiclesClient {
	
	@GetMapping("/GetAllVehicles")
    public ResponseEntity<List<VehiclesDTO>> getAllVehicles();
	
	@GetMapping("/getByIds")
    ResponseEntity<List<VehiclesDTO>> getVehiclesByIds(@RequestParam("ids") List<Integer> ids);
}
