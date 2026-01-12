package com.insurance.vehicle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Model {
    @Id
    private Long id;

    @ManyToOne
    private Brand brand;

    private String name;
    
    @Column(name = "risk_multiplier")
    private Double premiumMultiplier;
    
	public Long getId() {
		return id;
	}


	public Double getPremiumMultiplier() {
		return premiumMultiplier;
	}



	public Brand getBrand() {
		return brand;
	}


	public String getName() {
		return name;
	}


    
    
    
}
