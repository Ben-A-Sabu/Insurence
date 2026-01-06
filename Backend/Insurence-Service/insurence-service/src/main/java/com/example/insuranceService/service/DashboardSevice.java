package com.example.insuranceService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insuranceService.dto.DashboardDto;
import com.example.insuranceService.entity.ClaimStatus;
import com.example.insuranceService.entity.Insurer;
import com.example.insuranceService.repository.ClaimRepository;
import com.example.insuranceService.repository.InsurancePlanRepository;
import com.example.insuranceService.repository.InsurerRepository;

@Service
public class DashboardSevice {
	@Autowired
	private InsurerRepository insureRepo;
	@Autowired
	private InsurancePlanRepository planRepo;
	@Autowired
	private ClaimRepository claimRepo;
	
	public DashboardDto getDashboard(String email) {
		Insurer insurer=insureRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Insurer not found"));
		System.out.println(insurer.getEmail());
		long totalPlans=planRepo.countByInsurer(insurer);
		long activePlans=planRepo.countByInsurerAndActiveTrue(insurer);
		long inactivePlans=planRepo.countByInsurerAndActiveFalse(insurer);
		long pendingClaims=claimRepo.countByPlan_InsurerAndStatus(insurer, ClaimStatus.PENDING);
		long approvedClaims=claimRepo.countByPlan_InsurerAndStatus(insurer, ClaimStatus.APPROVED);
		long rejectedClaims=claimRepo.countByPlan_InsurerAndStatus(insurer, ClaimStatus.REJECTED);
		return new DashboardDto(totalPlans,activePlans,inactivePlans,pendingClaims,approvedClaims,rejectedClaims);
	}
}
