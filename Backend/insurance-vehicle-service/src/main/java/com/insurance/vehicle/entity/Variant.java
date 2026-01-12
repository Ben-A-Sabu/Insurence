package com.insurance.vehicle.entity;

import com.insurance.vehicle.constants.FuelType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Variant {
    @Id
    private Long id;

    @ManyToOne
    private Model model;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String name;
    
    @Column(name = "risk_multiplier")
    private Double premiumMultiplier;

	public Double getPremiumMultiplier() {
		return premiumMultiplier;
	}


	public Long getId() {
		return id;
	}



	public Model getModel() {
		return model;
	}


	public FuelType getFuelType() {
		return fuelType;
	}



	public String getName() {
		return name;
	}


    
    
}
