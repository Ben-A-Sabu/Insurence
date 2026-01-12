package com.example.insuranceService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.insuranceService.entity.Claim;
import com.example.insuranceService.entity.ClaimStatus;
import com.example.insuranceService.entity.Insurer;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long>{
	List<Claim> findByPlan_Insurer(Insurer insurer);
	List<Claim> findByPlan_InsurerAndStatus(Insurer insurer,ClaimStatus status);
	long countByPlan_InsurerAndStatus(Insurer insurer,ClaimStatus status);
}
