package com.Manas.UCSP.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Manas.UCSP.Entity.VehicleType;
import com.Manas.UCSP.Repository.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository repository;
	
	public VehicleType addVehicleType(VehicleType type) {
		return repository.save(type);
	}
	
	public List<VehicleType> getAllVehicleTypes() {
		List<VehicleType> allVehicleType = repository.findAll();
		return allVehicleType;
	}
	
	public VehicleType retrieveVehicleTypeById(int vehicleTypeId) {
		List<VehicleType> allVehicleType = getAllVehicleTypes();
		Predicate<? super VehicleType> predicate = vehicleType -> vehicleType.getId() == vehicleTypeId;
		Optional<VehicleType> optionalVehicleType = allVehicleType.stream().filter(predicate).findFirst();
		return optionalVehicleType.orElse(null);
	}
	
	public boolean updateVehicleTypeById(int vehicleTypeId, VehicleType updatedVehicleType) {
		Optional<VehicleType> existingVehicleType = repository.findById(vehicleTypeId);
		if (existingVehicleType.isPresent()) {
			updatedVehicleType.setId(vehicleTypeId);
			repository.save(updatedVehicleType);
			return true;
		}
		return false;
	}
	
	public int deleteVehicleTypeById(int vehicleTypeId) {
		Optional<VehicleType> existingVehicleType = repository.findById(vehicleTypeId);
		if (existingVehicleType.isPresent()) {
			repository.deleteById(vehicleTypeId);
			return vehicleTypeId;
		}
		return -1;
	}
}
