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

import com.Manas.UCSP.Entity.VehicleStatus;
import com.Manas.UCSP.Service.VehicleStatusService;

@RestController
@RequestMapping("/VehicleService/VehicleStatus")
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService service;

	@PostMapping("AddVehicleStatus")
	public VehicleStatus addVehicleStatus(@RequestBody VehicleStatus status) {
		return service.AddVehicleStatus(status);
	}
	
	@GetMapping("GetAllVehicleStatus")
    public ResponseEntity<List<VehicleStatus>> getAllVehicleStatus() {
        List<VehicleStatus> allVehicleStatus = service.getAllVehicleStatus();
        return new ResponseEntity<>(allVehicleStatus, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{vehicleStatusId}", method= RequestMethod.GET)
	public ResponseEntity<VehicleStatus> retrieveVehicleStatusById(@PathVariable int vehicleStatusId) {
		VehicleStatus singleVehicleStatus = service.retrieveVehicleStatusById(vehicleStatusId);
		if(singleVehicleStatus == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(singleVehicleStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{vehicleStatusId}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateVehicleStatusById(int vehicleStatusId, VehicleStatus vehicleStatus) {
		if (vehicleStatusId != vehicleStatus.getId())
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return service.updateVehicleStatusById(vehicleStatusId, vehicleStatus) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{vehicleStatusId}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteVehicleStatusById(@PathVariable int vehicleStatusId) {
		return service.deleteVehicleStatusById(vehicleStatusId) != -1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
