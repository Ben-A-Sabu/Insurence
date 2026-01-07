package com.insurance.vehicle.embadabbles;

import jakarta.persistence.Embeddable;

@Embeddable
public class RegistrationDetails {
    private String vehicleNumber;
    private Integer manufacturingYear;
    
    
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Integer getManufacturingYear() {
		return manufacturingYear;
	}
	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}
    
    
}
