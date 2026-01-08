package com.insurance.vehicle.entity;

import com.insurance.vehicle.constants.FuelType;
import com.insurance.vehicle.embadabbles.RegistrationDetails;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    private Long vehicleId;

    @Embedded
    private RegistrationDetails registrationDetails;

    // the idea is many vehicles can fall under same RTO
    @ManyToOne
    private RTO rto;

    // the idea is many vehicles can be under same brand
    @ManyToOne
    private Brand brand;

    // the idea is many vehicles can be under same modal
    @ManyToOne
    private Model model;

    @ManyToOne
    private Variant variant;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public RegistrationDetails getRegistrationDetails() {
		return registrationDetails;
	}


	public RTO getRto() {
		return rto;
	}


	public Brand getBrand() {
		return brand;
	}


	public Model getModel() {
		return model;
	}

	public Variant getVariant() {
		return variant;
	}


	public FuelType getFuelType() {
		return fuelType;
	}


}

