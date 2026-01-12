package com.example.insuranceService.service;

import java.util.Objects;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insuranceService.dto.PlanRequestDto;
import com.example.insuranceService.entity.InsurancePlan;
import com.example.insuranceService.repository.InsurancePlanRepository;
import com.example.insuranceService.repository.InsurerRepository;
import com.example.insuranceService.entity.*;

@Service
public class PlanService {
	@Autowired
    private InsurancePlanRepository planRepo;

    @Autowired
    private InsurerRepository insurerRepo;
    
    
    public InsurancePlan createPlan(String email, PlanRequestDto dto) {
    	System.out.println("Hi ");
        Insurer insurer = insurerRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Not found"));

        InsurancePlan plan = new InsurancePlan();
        plan.setPlanName(dto.getPlanName());
        plan.setPremium(dto.getPremium());
        plan.setDuration(dto.getDuration());
        plan.setInsurer(insurer);

        return planRepo.save(plan);
    }
    public InsurancePlan getOwnerPlan(String email,Long planId) {
    	Insurer insurer=insurerRepo.findByEmail(email).orElseThrow(()->new RuntimeException("Insurer not found"));
    	InsurancePlan plan=planRepo.findById(planId).orElseThrow(()->new RuntimeException("Plan not found"));
    	if(!Objects.equals(plan.getInsurer().getInsurerId(),(insurer.getInsurerId()))) {
    		throw new RuntimeException("Unauthorized access");
    	}
    	return plan;
    }
    public InsurancePlan activatedPlan(String email,Long planId) {
    	InsurancePlan plan=getOwnerPlan(email, planId);
    	plan.setActive(true);
    	return planRepo.save(plan);
    }
    public InsurancePlan deActivatedPlan(String email,Long planId) {
    	InsurancePlan plan=getOwnerPlan(email, planId);
    	plan.setActive(false);
    	return planRepo.save(plan);
    }
}
