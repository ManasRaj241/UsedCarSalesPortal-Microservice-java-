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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Manas.UCSP.Entity.VehicleType;
import com.Manas.UCSP.Service.VehicleTypeService;

@RestController
@RequestMapping("/VehicleService/VehicleType")
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService service;

	@PostMapping("AddVehicleType")
	public VehicleType addVehicleType(@RequestBody VehicleType type) {
		return service.addVehicleType(type);
	}
	
	@GetMapping("GetAllVehicleTypes")
    public ResponseEntity<List<VehicleType>> getAllVehicleTypes() {
        List<VehicleType> allVehicleType = service.getAllVehicleTypes();
        return new ResponseEntity<>(allVehicleType, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{vehicleTypeId}", method= RequestMethod.GET)
	public ResponseEntity<VehicleType> retrieveVehicleTypeById(@PathVariable int vehicleTypeId) {
		VehicleType singleVehicleType = service.retrieveVehicleTypeById(vehicleTypeId);
		if(singleVehicleType == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(singleVehicleType, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{vehicleTypeId}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateVehicleById(int vehicleTypeId, VehicleType vehicleType) {
		if (vehicleTypeId != vehicleType.getId())
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return service.updateVehicleTypeById(vehicleTypeId, vehicleType) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{vehicleTypeId}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteVehicleTypeById(@PathVariable int vehicleTypeId) {
		return service.deleteVehicleTypeById(vehicleTypeId) != -1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
