package com.Manas.UCSP.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Manas.UCSP.DTO.CartDTO;
import com.Manas.UCSP.DTO.CartRequestDTO;
import com.Manas.UCSP.Entity.Vehicles;
import com.Manas.UCSP.Repository.VehiclesRepository;

@Service
public class VehicleService {

	@Autowired
	private VehiclesRepository repository;
	private List<Vehicles> vehicleList;

	public VehicleService() {
		initializeVehicleList();
	}

	private void initializeVehicleList() {
		vehicleList = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			Vehicles vehicle = new Vehicles();
			vehicle.setVehicleUniqueId(UUID.randomUUID());
			vehicle.setVehicleName("Sample Vehicle " + i);
			vehicle.setVehicleModelId(1);
			vehicle.setVehicleStatusId(1);
			vehicle.setVehicleTypeId(1);
			vehicle.setPrice(20000 + i * 1000);
			vehicle.setVehicleImage("image" + i + ".jfif");
			vehicle.setSellerName("Seller " + i);
			vehicle.setDistanceTravelled(0);

			vehicleList.add(vehicle);
		}
	}
	
	public List<Vehicles> getVehiclesByIds(List<Integer> vehicleIds) {
        return repository.findByVehicleIdIn(vehicleIds);
    }

	public Vehicles addVehicle(Vehicles vehicle) {
		return repository.save(vehicle);
	}

	public List<Vehicles> getAllVehicles() {
		List<Vehicles> allVehicles = repository.findAll();
		return allVehicles;
	}

	public List<Vehicles> getFeaturedVehicles() {
		return getVehicleList();
	}

	public Vehicles retrieveVehicleById(int vehicleId) {
		List<Vehicles> allVehicles = getAllVehicles();
		Predicate<? super Vehicles> predicate = vehicle -> vehicle.getVehicleId() == vehicleId;
		Optional<Vehicles> optionalVehicle = allVehicles.stream().filter(predicate).findFirst();
		return optionalVehicle.orElse(null);
	}

	public boolean updateVehicleById(int vehicleId, Vehicles updatedVehicle) {
		Optional<Vehicles> existingVehicle = repository.findById(vehicleId);
		if (existingVehicle.isPresent()) {
			updatedVehicle.setVehicleId(vehicleId);
			repository.save(updatedVehicle);
			return true;
		}
		return false;
	}

	public int deleteVehicleById(int vehicleId) {
		Optional<Vehicles> existingVehicle = repository.findById(vehicleId);
		if (existingVehicle.isPresent()) {
			repository.deleteById(vehicleId);
			return vehicleId;
		}
		return -1;
	}

	public List<Vehicles> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicles> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public CartDTO prepareCartObj(CartRequestDTO cartRequest) {
		CartDTO obj = new CartDTO();
		obj.setEmailId(cartRequest.getEmailId());
		obj.setVehicleId(cartRequest.getVehicle().getVehicleId());
		return obj;
	}
	
	public List<Vehicles> searchByVehicleName(String vehicleName) {
        return repository.findByVehicleName(vehicleName);
    }

    public List<Vehicles> searchByVehicleModel(Integer vehicleModelId) {
        return repository.findByVehicleModel_Id(vehicleModelId);
    }

    public List<Vehicles> searchByVehicleType(Integer vehicleTypeId) {
        return repository.findByVehicleType_Id(vehicleTypeId);
    }

    public List<Vehicles> searchByVehicleStatus(Integer vehicleStatusId) {
        return repository.findByVehicleStatus_Id(vehicleStatusId);
    }
}
