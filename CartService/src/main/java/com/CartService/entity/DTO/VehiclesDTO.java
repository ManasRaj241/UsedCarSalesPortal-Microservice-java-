package com.CartService.entity.DTO;

import java.util.UUID;

public class VehiclesDTO {
    private int vehicleId;
    private UUID vehicleUniqueId;
    private String vehicleName;
    private Integer vehicleModelId;
    private VehicleModelDTO vehicleModel;
    private Integer vehicleStatusId;
    private VehicleStatusDTO vehicleStatus;
    private Integer vehicleTypeId;
    private VehicleTypeDTO vehicleType;
    private Integer price;
    private String vehicleImage;
    private String sellerName;
    private Integer distanceTravelled;

    // Getters and Setters

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getVehicleUniqueId() {
        return vehicleUniqueId;
    }

    public void setVehicleUniqueId(UUID vehicleUniqueId) {
        this.vehicleUniqueId = vehicleUniqueId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Integer getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(Integer vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public VehicleModelDTO getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModelDTO vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getVehicleStatusId() {
        return vehicleStatusId;
    }

    public void setVehicleStatusId(Integer vehicleStatusId) {
        this.vehicleStatusId = vehicleStatusId;
    }

    public VehicleStatusDTO getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatusDTO vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public VehicleTypeDTO getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypeDTO vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(Integer distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }
}