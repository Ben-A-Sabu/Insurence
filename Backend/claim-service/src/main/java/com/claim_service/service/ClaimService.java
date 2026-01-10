package com.claim_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claim_service.dto.ClaimDecisionDto;
import com.claim_service.dto.ClaimRequestDto;
import com.claim_service.entity.Claim;
import com.claim_service.exception.ClaimNotFoundException;
import com.claim_service.repository.ClaimRepository;

import jakarta.transaction.Transactional;

@Service
public class ClaimService{
	private final ClaimRepository repository;
	
	public ClaimService(ClaimRepository repository) {
		this.repository=repository;
	}
	
	public Claim raiseClaim(Long userId, ClaimRequestDto dto) {
		Claim claim = new Claim();
		claim.setUserId(userId);
		claim.setPolicyId(dto.getPolicyId());
		claim.setAmount(dto.getAmount());
		claim.setReason(dto.getReason());
		claim.setStatus("PENDING");
		return repository.save(claim);
	}
	public List<Claim> getUserClaims(Long userId){
		return repository.findByUserId(userId);
	}
	
	public List<Claim> getAllClaims(){
		return repository.findAll();
	}
	
	@Transactional
	public void op(Long id,ClaimDecisionDto dto) {
		repository.findById(id).orElseThrow(()->new ClaimNotFoundException("Claim not found."));
		
		repository.decideClaim(id, dto.getStatus(), dto.getInsurerReason());
	}
	
	
	
	
	
	
}