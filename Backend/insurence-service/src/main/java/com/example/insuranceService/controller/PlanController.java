package com.example.insuranceService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insuranceService.dto.PlanRequestDto;
import com.example.insuranceService.entity.InsurancePlan;
import com.example.insuranceService.service.PlanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/insurer/plan")
public class PlanController {
	@Autowired
	private PlanService service;
	
	@PostMapping
	public InsurancePlan create(@Valid @RequestBody PlanRequestDto dto,Authentication authentication) {
		String email=authentication.getName();
		return service.createPlan(email,dto);
	}
	@PutMapping("/{id}/activate")
	public InsurancePlan activate(@PathVariable Long id,Authentication authentication) {
		return service.activatedPlan(authentication.getName(),id);
	}
	@PutMapping("/{id}/deactivate")
	public InsurancePlan deActivate(@PathVariable Long id,Authentication authentication) {
		return service.deActivatedPlan(authentication.getName(),id);
	}
}
