package com.insurance.vehicle.entity;

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
    

	public Long getId() {
		return id;
	}


	public Brand getBrand() {
		return brand;
	}


	public String getName() {
		return name;
	}


    
    
    
}
