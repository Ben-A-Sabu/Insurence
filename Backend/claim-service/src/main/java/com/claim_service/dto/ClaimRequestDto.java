package com.claim_service.dto;

import jakarta.validation.constraints.*;

public class ClaimRequestDto{
	@NotNull 
	private Long policyId;
	
	@NotNull
	private Double amount;
	
	@NotBlank
	private String reason;

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
