package com.insurance.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.vehicle.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
