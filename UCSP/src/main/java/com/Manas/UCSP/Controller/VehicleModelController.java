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

import com.Manas.UCSP.Entity.VehicleModel;
import com.Manas.UCSP.Service.VehicleModelService;

@RestController
@RequestMapping("/VehicleService/VehicleModel")
public class VehicleModelController {

	@Autowired
	private VehicleModelService service;

	@PostMapping("AddVehicleModel")
	public VehicleModel addVehicleModel(@RequestBody VehicleModel model) {
		return service.AddVehicleModel(model);
	}
	
	@GetMapping("GetAllVehicleModels")
    public ResponseEntity<List<VehicleModel>> getAllVehicleModels() {
        List<VehicleModel> allVehicleModel = service.getAllVehicleModels();
        return new ResponseEntity<>(allVehicleModel, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{vehicleModelId}", method= RequestMethod.GET)
	public ResponseEntity<VehicleModel> retrieveVehicleModelById(@PathVariable int vehicleModelId) {
		VehicleModel singleVehicleModel = service.retrieveVehicleModelById(vehicleModelId);
		if(singleVehicleModel == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(singleVehicleModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{vehicleModelId}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateVehicleById(int vehicleModelId, VehicleModel vehicleModel) {
		if (vehicleModelId != vehicleModel.getId())
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return service.updateVehicleModelById(vehicleModelId, vehicleModel) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{vehicleModelId}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteVehicleModelById(@PathVariable int vehicleModelId) {
		return service.deleteVehicleModelById(vehicleModelId) != -1 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
