package com.example.insuranceService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long claimId;
	
	private String reason;
	private double claimAmount;
	@Enumerated(EnumType.STRING)
	private ClaimStatus status;
	
}
