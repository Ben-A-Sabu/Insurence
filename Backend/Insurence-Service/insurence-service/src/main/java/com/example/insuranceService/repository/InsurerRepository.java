package com.example.insuranceService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insuranceService.entity.InsurancePlan;
import com.example.insuranceService.entity.Insurer;

@Repository
public interface InsurerRepository extends JpaRepository<Insurer, Long>{
	

	Optional<Insurer> findByEmail(String email);
//	Optional<Insurer> findByEmail(String email);
	
}
