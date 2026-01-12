package com.example.insuranceService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insuranceService.entity.InsurancePlan;
import com.example.insuranceService.entity.Insurer;

@Repository
public interface InsurancePlanRepository extends JpaRepository<InsurancePlan, Long>{
	long countByInsurer(Insurer insurer);
	long countByInsurerAndActiveTrue(Insurer insurer);
	long countByInsurerAndActiveFalse(Insurer insurer);
}
