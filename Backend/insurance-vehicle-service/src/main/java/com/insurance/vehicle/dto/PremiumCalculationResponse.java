package com.insurance.vehicle.dto;

public class PremiumCalculationResponse {

    private Double premium;

    public PremiumCalculationResponse(Double premium) {
        this.premium = premium;
    }

    public Double getPremium() {
        return premium;
    }
}