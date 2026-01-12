package com.insurance.vehicle.dto;

public class PremiumCalculationRequest {

    private double rtoMultiplier;
    private double brandMultiplier;
    private double modelMultiplier;
    private double variantMultiplier;
    
    
	public double getRtoMultiplier() {
		return rtoMultiplier;
	}
	public void setRtoMultiplier(double rtoMultiplier) {
		this.rtoMultiplier = rtoMultiplier;
	}
	public double getBrandMultiplier() {
		return brandMultiplier;
	}
	public void setBrandMultiplier(double brandMultiplier) {
		this.brandMultiplier = brandMultiplier;
	}
	public double getModelMultiplier() {
		return modelMultiplier;
	}
	public void setModelMultiplier(double modelMultiplier) {
		this.modelMultiplier = modelMultiplier;
	}
	public double getVariantMultiplier() {
		return variantMultiplier;
	}
	public void setVariantMultiplier(double variantMultiplier) {
		this.variantMultiplier = variantMultiplier;
	}

    // getters & setters
}
