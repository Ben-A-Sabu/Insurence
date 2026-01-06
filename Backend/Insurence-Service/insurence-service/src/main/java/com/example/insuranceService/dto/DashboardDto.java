package com.example.insuranceService.dto;


public class DashboardDto {
	private long totalPlans;
	private long activePlans;
	private long inactivePlans;
	private long pendingClaims;
	private long approvedClaims;
	private long rejectedClaims;
	
	
	public DashboardDto(long totalPlans, long activePlans, long inactivePlans, long pendingClaims, long approvedClaims,
			long rejectedClaims) {
		
		this.totalPlans = totalPlans;
		this.activePlans = activePlans;
		this.inactivePlans = inactivePlans;
		this.pendingClaims = pendingClaims;
		this.approvedClaims = approvedClaims;
		this.rejectedClaims = rejectedClaims;
	}
	public long getTotalPlans() {
		return totalPlans;
	}
	public void setTotalPlans(long totalPlans) {
		this.totalPlans = totalPlans;
	}
	public long getActivePlans() {
		return activePlans;
	}
	public void setActivePlans(long activePlans) {
		this.activePlans = activePlans;
	}
	public long getInactivePlans() {
		return inactivePlans;
	}
	public void setInactivePlans(long inactivePlans) {
		this.inactivePlans = inactivePlans;
	}
	public long getPendingClaims() {
		return pendingClaims;
	}
	public void setPendingClaims(long pendingClaims) {
		this.pendingClaims = pendingClaims;
	}
	public long getApprovedClaims() {
		return approvedClaims;
	}
	public void setApprovedClaims(long approvedClaims) {
		this.approvedClaims = approvedClaims;
	}
	public long getRejectedClaims() {
		return rejectedClaims;
	}
	public void setRejectedClaims(long rejectedClaims) {
		this.rejectedClaims = rejectedClaims;
	}
}
