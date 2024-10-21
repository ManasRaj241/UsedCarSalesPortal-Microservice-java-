package com.Manas.UCSP.Entity;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    @Column(nullable = false, unique = true)
    private UUID vehicleUniqueId;

    @NotBlank
    @Size(max = 50)
    private String vehicleName;

    @NotNull
    private Integer vehicleModelId;

    @ManyToOne
    @JoinColumn(name = "vehicleModelId", insertable = false, updatable = false)
    private VehicleModel vehicleModel;

    @NotNull
    private Integer vehicleStatusId;

    @ManyToOne
    @JoinColumn(name = "vehicleStatusId", insertable = false, updatable = false)
    private VehicleStatus vehicleStatus;

    @NotNull
    private Integer vehicleTypeId;

    @ManyToOne
    @JoinColumn(name = "vehicleTypeId", insertable = false, updatable = false)
    private VehicleType vehicleType;

    @NotNull
    private Integer price;

    @NotBlank
    @Size(max = 50)
    private String vehicleImage;

    @NotBlank
    @Size(max = 50)
    private String sellerName;

    @NotNull
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

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getVehicleStatusId() {
        return vehicleStatusId;
    }

    public void setVehicleStatusId(Integer vehicleStatusId) {
        this.vehicleStatusId = vehicleStatusId;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
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
 