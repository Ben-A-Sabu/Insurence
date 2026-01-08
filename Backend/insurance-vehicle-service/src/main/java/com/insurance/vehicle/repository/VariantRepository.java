package com.insurance.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.vehicle.constants.FuelType;
import com.insurance.vehicle.entity.Variant;

public interface VariantRepository  extends JpaRepository<Variant, Long> {

    List<Variant> findByModelIdAndFuelType(Long modelId, FuelType fuelType);

    @Query("SELECT DISTINCT v.fuelType FROM Variant v WHERE v.model.id = :modelId")
    List<FuelType> findFuelTypesByModelId(Long modelId);
}