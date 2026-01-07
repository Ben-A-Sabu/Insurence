package com.claim_service.dto;

import jakarta.validation.constraints.NotBlank;

public class ClaimDecisionDto {
	@NotBlank
	private String status;
	
	@NotBlank
	private String insurerReason;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInsurerReason() {
		return insurerReason;
	}

	public void setInsurerReason(String insurerReason) {
		this.insurerReason = insurerReason;
	}
}
