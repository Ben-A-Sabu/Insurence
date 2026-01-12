package com.insurance.vehicle.dto;

import com.insurance.vehicle.constants.FuelType;

public class VehiclePremiumRequest {

    private Long rtoId;
    private Long brandId;
    private Long modelId;
    private Long variantId;
    private FuelType fuelType;
    
    
    
    
	public Long getVariantId() {
		return variantId;
	}
	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getRtoId() {
		return rtoId;
	}
	public void setRtoId(Long rtoId) {
		this.rtoId = rtoId;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

    // getters & setters
}
