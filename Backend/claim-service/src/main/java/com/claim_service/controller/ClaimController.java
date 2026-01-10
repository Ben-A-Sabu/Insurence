package com.claim_service.controller;


import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.claim_service.dto.ClaimDecisionDto;
import com.claim_service.dto.ClaimRequestDto;
import com.claim_service.entity.Claim;
import com.claim_service.service.ClaimService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/claims")
public class ClaimController{
	private final ClaimService service;
	
	public ClaimController(ClaimService service) {
		this.service=service;
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('USER')")
	public Claim raiseClaim(@RequestBody @Valid ClaimRequestDto dto,Authentication authentication) {
		String userIdStr=authentication.getPrincipal().toString();
		Long userId=Long.parseLong(userIdStr);
		return service.raiseClaim(userId, dto);
	}
	
	@GetMapping("/user")
	public List<Claim> userClaims(Authentication authentication){
		Long userId=(Long) authentication.getPrincipal();
		return service.getUserClaims(userId);
	}
	
	@GetMapping("/insurer")
	public List<Claim> allClaims(){
		return service.getAllClaims();
	}
	@PutMapping("/{id}/decision")
	@PreAuthorize("hasAuthority('INSURER')")
	public String decide(@PathVariable Long id,@RequestBody @Valid ClaimDecisionDto dto) {
		service.decideClaim(id,dto);
		return "Claim: "+dto.getStatus();
		
	}
	
	
	
}