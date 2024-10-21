package com.Manas.UCSP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Manas.UCSP.Client.CartClient;
import com.Manas.UCSP.DTO.CartDTO;
import com.Manas.UCSP.DTO.CartRequestDTO;
import com.Manas.UCSP.Entity.Vehicles;
import com.Manas.UCSP.Service.VehicleService;

@RestController
@RequestMapping("/VehicleService/Vehicles")
public class VehiclesController {

	@Autowired
	private VehicleService service;
	
	@Autowired
	private CartClient client;

	@PostMapping("AddVehicle")
	public Vehicles addVehicle(@RequestBody Vehicles vehicle) {
		return service.addVehicle(vehicle);
	}
	
	/*
	 * 
	 * Used in Cart service
	 * 
	 */
	
	@GetMapping("/getByIds")
    public ResponseEntity<List<Vehicles>> getVehiclesByIds(@RequestParam List<Integer> ids) {
        List<Vehicles> vehicles = service.getVehiclesByIds(ids);
        return ResponseEntity.ok(vehicles);
    }
	
	@GetMapping("GetAllVehicles")
    public ResponseEntity<List<Vehicles>> getAllVehicles() {
        List<Vehicles> allVehicles = service.getAllVehicles();
        return new ResponseEntity<>(allVehicles, HttpStatus.OK);
    }
		
	
	/*
	 * 
	 * Used in Cart service
	 * 
	 */
	
	@GetMapping("GetAllFeaturedVehicles")
    public ResponseEntity<List<Vehicles>> getFeaturedVehicles() {
        List<Vehicles> featuredVehicles = service.getFeaturedVehicles();
        return new ResponseEntity<>(featuredVehicles, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{vehicleId}", method= RequestMethod.GET)
	public ResponseEntity<Vehicles> retrieveVehicleById(@PathVariable int vehicleId) {
		Vehicles singleVehicle = service.retrieveVehicleById(vehicleId);
		if(singleVehicle == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(singleVehicle, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{vehicleId}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateVehicleById(int vehicleId, Vehicles vehicles) {
		if (vehicleId != vehicles.getVehicleId())
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return service.updateVehicleById(vehicleId, vehicles) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{vehicleId}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteVehicleById(@PathVariable int vehicleId) {
		return service.deleteVehicleById(vehicleId) != -1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*
	 * =========================================================
	 * Calling Cart Service using Feign Client
	 * =========================================================
	 */
	
	@PostMapping("AddToCart")
	public CartDTO addToCart(@RequestBody CartRequestDTO cartRequest) {
		CartDTO cart = service.prepareCartObj(cartRequest);
		return client.addToCart(cart);
	}
	
	/*
	 * =========================================================
	 * Calling Cart Service using Feign Client
	 * =========================================================
	 */
	
}
