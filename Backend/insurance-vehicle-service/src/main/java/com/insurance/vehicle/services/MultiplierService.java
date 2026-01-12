package com.insurance.vehicle.services;

import org.springframework.stereotype.Service;

import com.insurance.vehicle.dto.PremiumCalculationRequest;

@Service
public class MultiplierService {

    public Double calculatePremium(PremiumCalculationRequest request) {

        return  request.getRtoMultiplier()
                * request.getBrandMultiplier()
                * request.getModelMultiplier()
                * request.getVariantMultiplier();
    }
}
