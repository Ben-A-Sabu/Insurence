package com.example.insuranceService.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.insuranceService.entity.Claim;
import com.example.insuranceService.entity.ClaimStatus;
import com.example.insuranceService.entity.Insurer;
import com.example.insuranceService.repository.ClaimRepository;
import com.example.insuranceService.repository.InsurerRepository;

@Service
public class ClaimService {
	@Autowired
	private ClaimRepository claimRepo;
	
	@Autowired
	private InsurerRepository insurerRepo;
	
	public List<Claim> getAllClaims(String email){
		Insurer insurer=insurerRepo.findByEmail(email).orElseThrow();
		return claimRepo.findByPlan_Insurer(insurer);
	}
	public List<Claim> getPendingClaims(String email){
		Insurer insurer= insurerRepo.findByEmail(email).orElseThrow();
		return claimRepo.findByPlan_InsurerAndStatus(insurer, ClaimStatus.PENDING);
	}
	
	public Claim approveClaim(String email,Long claimId,String remark) {
		Claim claim=getOwendClaim(email, claimId);
		claim.setStatus(ClaimStatus.APPROVED);
		claim.setInsurerRemark(remark);
		return claimRepo.save(claim);
	}
	public Claim rejectClaim(String email,Long claimId,String remark) {
		Claim claim=getOwendClaim(email, claimId);
		claim.setStatus(ClaimStatus.REJECTED);
		claim.setInsurerRemark(remark);
		return claimRepo.save(claim);
	}
	public Claim getOwendClaim(String email,Long claimId) {
		Insurer insurer=insurerRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Insurer not found"));
		Claim claim=claimRepo.findById(claimId).orElseThrow(()-> new RuntimeException("Claim not found"));
		if(!Objects.equals(claim.getPlan().getInsurer().getInsurerId(),insurer.getInsurerId())) {
			throw new RuntimeException("Unauthorized Cliam access");
		}
		return claim;
	}
}
