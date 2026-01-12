package com.insurance.vehicle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Brand {
    @Id
    private Long id;
    private String name;
    // Premium-related
    @Column(name = "risk_multiplier")
    private Double premiumMultiplier;
    
    
	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}


	public Double getPremiumMultiplier() {
		return premiumMultiplier;
	}




	
    
}