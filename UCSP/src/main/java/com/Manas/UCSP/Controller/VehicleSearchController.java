package com.Manas.UCSP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Manas.UCSP.Entity.Vehicles;
import com.Manas.UCSP.Service.VehicleService;

@RestController
@RequestMapping("/VehicleService/Vehicles")
public class VehicleSearchController {

	@Autowired
	private VehicleService service;
	
	@GetMapping("/searchByVehicleName/{vehicleName}")
    public ResponseEntity<List<Vehicles>> searchByVehicleName(@PathVariable String vehicleName) {
        List<Vehicles> vehicles = service.searchByVehicleName(vehicleName);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/searchByVehicleModel/{vehicleModelId}")
    public ResponseEntity<List<Vehicles>> searchByVehicleModel(@PathVariable Integer vehicleModelId) {
        List<Vehicles> vehicles = service.searchByVehicleModel(vehicleModelId);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/searchByVehicleType/{vehicleTypeId}")
    public ResponseEntity<List<Vehicles>> searchByVehicleType(@PathVariable Integer vehicleTypeId) {
        List<Vehicles> vehicles = service.searchByVehicleType(vehicleTypeId);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/searchByVehicleStatus/{vehicleStatusId}")
    public ResponseEntity<List<Vehicles>> searchByVehicleStatus(@PathVariable Integer vehicleStatusId) {
        List<Vehicles> vehicles = service.searchByVehicleStatus(vehicleStatusId);
        return ResponseEntity.ok(vehicles);
    }
}
