package com.Manas.UCSP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Manas.UCSP.Entity.Vehicles;

public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {

	List<Vehicles> findByVehicleIdIn(List<Integer> vehicleIds);
	
	List<Vehicles> findByVehicleName(String vehicleName);
    List<Vehicles> findByVehicleModel_Id(Integer vehicleModelId);
    List<Vehicles> findByVehicleType_Id(Integer vehicleTypeId);
    List<Vehicles> findByVehicleStatus_Id(Integer vehicleStatusId);
}
