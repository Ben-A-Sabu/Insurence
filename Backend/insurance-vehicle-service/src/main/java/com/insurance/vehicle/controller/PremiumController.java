package com.insurance.vehicle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.vehicle.dto.PremiumCalculationResponse;
import com.insurance.vehicle.dto.VehiclePremiumRequest;
import com.insurance.vehicle.services.VehiclePremiumService;

@RestController
@RequestMapping("/api/muliplier")

public class PremiumController {

    private  VehiclePremiumService premiumService;
    
   
	public PremiumController(VehiclePremiumService premiumService) {
		this.premiumService = premiumService;
	}


	@PostMapping("/calculate")
    public ResponseEntity<PremiumCalculationResponse> calculatePremium(
            @RequestBody VehiclePremiumRequest request) {

        return ResponseEntity.ok(
                premiumService.calculatePremium(request)
        );
    }
}
