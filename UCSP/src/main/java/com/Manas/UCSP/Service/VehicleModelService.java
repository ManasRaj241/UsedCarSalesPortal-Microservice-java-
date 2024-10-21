package com.Manas.UCSP.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Manas.UCSP.Entity.VehicleModel;
import com.Manas.UCSP.Repository.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository repository;

	public VehicleModel AddVehicleModel(VehicleModel model) {
		return repository.save(model);
	}
	
	public List<VehicleModel> getAllVehicleModels() {
		List<VehicleModel> allVehicleModel = repository.findAll();
		return allVehicleModel;
	}
	
	public VehicleModel retrieveVehicleModelById(int vehicleModelId) {
		List<VehicleModel> allVehicleModel = getAllVehicleModels();
		Predicate<? super VehicleModel> predicate = vehicleModel -> vehicleModel.getId() == vehicleModelId;
		Optional<VehicleModel> optionalVehicleModel = allVehicleModel.stream().filter(predicate).findFirst();
		return optionalVehicleModel.orElse(null);
	}
	
	public boolean updateVehicleModelById(int vehicleModelId, VehicleModel updatedVehicleModel) {
		Optional<VehicleModel> existingVehicleModel = repository.findById(vehicleModelId);
		if (existingVehicleModel.isPresent()) {
			updatedVehicleModel.setId(vehicleModelId);
			repository.save(updatedVehicleModel);
			return true;
		}
		return false;
	}
	
	public int deleteVehicleModelById(int vehicleModelId) {
		Optional<VehicleModel> existingVehicleModel = repository.findById(vehicleModelId);
		if (existingVehicleModel.isPresent()) {
			repository.deleteById(vehicleModelId);
			return vehicleModelId;
		}
		return -1;
	}
}
