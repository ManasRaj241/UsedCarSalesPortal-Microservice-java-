package com.Manas.UCSP.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Manas.UCSP.Entity.VehicleStatus;
import com.Manas.UCSP.Repository.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository repository;
	
	public VehicleStatus AddVehicleStatus(VehicleStatus status) {
		return repository.save(status);
	}
	
	public List<VehicleStatus> getAllVehicleStatus() {
		List<VehicleStatus> allVehicleStatus = repository.findAll();
		return allVehicleStatus;
	}
	
	public VehicleStatus retrieveVehicleStatusById(int vehicleStatusId) {
		List<VehicleStatus> allVehicleStatus = getAllVehicleStatus();
		Predicate<? super VehicleStatus> predicate = vehicleStatus -> vehicleStatus.getId() == vehicleStatusId;
		Optional<VehicleStatus> optionalVehicleStatus = allVehicleStatus.stream().filter(predicate).findFirst();
		return optionalVehicleStatus.orElse(null);
	}
	
	public boolean updateVehicleStatusById(int vehicleStatusId, VehicleStatus updatedVehicleStatus) {
		Optional<VehicleStatus> existingVehicleStatus = repository.findById(vehicleStatusId);
		if (existingVehicleStatus.isPresent()) {
			updatedVehicleStatus.setId(vehicleStatusId);
			repository.save(updatedVehicleStatus);
			return true;
		}
		return false;
	}
	
	public int deleteVehicleStatusById(int vehicleStatusId) {
		Optional<VehicleStatus> existingVehicleStatus = repository.findById(vehicleStatusId);
		if (existingVehicleStatus.isPresent()) {
			repository.deleteById(vehicleStatusId);
			return vehicleStatusId;
		}
		return -1;
	}
}
