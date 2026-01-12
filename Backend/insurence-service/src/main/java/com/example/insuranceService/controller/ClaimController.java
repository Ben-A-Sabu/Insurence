package com.example.insuranceService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.insuranceService.entity.Claim;
import com.example.insuranceService.service.ClaimService;

@RestController
@RequestMapping("/insurer/claims")
public class ClaimController {
	@Autowired
	private ClaimService service;
	@GetMapping
	public List<Claim> getClaims(Authentication auth){
		return service.getAllClaims(auth.getName());
	}
	@PutMapping("/{id}/approve")
	public Claim approve(@PathVariable Long id,@RequestParam String remark,Authentication auth) {
		return service.approveClaim(auth.getName(), id, remark);
	}
	@PutMapping("/{id}/reject")
	public Claim reject(@PathVariable Long id,@RequestParam String remark,Authentication auth) {
		return service.rejectClaim(auth.getName(), id, remark);
	}
	@GetMapping("/pending")
	public List<Claim> pending(Authentication auth){
		return service.getPendingClaims(auth.getName());
	}
}
