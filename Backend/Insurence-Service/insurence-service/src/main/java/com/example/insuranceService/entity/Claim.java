package com.example.insuranceService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long claimId;
	
	private String reason;
	private double claimAmount;
	
	@Enumerated(EnumType.STRING)
	private ClaimStatus status;
	private String insurerRemark;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="plan_id",nullable = false)
	private InsurancePlan plan;

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public ClaimStatus getStatus() {
		return status;
	}

	public void setStatus(ClaimStatus status) {
		this.status = status;
	}

	public String getInsurerRemark() {
		return insurerRemark;
	}

	public void setInsurerRemark(String insurerRemark) {
		this.insurerRemark = insurerRemark;
	}

	public InsurancePlan getPlan() {
		return plan;
	}

	public void setPlan(InsurancePlan plan) {
		this.plan = plan;
	}
}
