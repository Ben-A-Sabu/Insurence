package com.example.insuranceService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insuranceService.dto.DashboardDto;
import com.example.insuranceService.service.DashboardSevice;

@RestController
@RequestMapping("/insurer/dashboard")
public class DashboardContoller {
	@Autowired
	private DashboardSevice service;
	@GetMapping
	public DashboardDto dashboard(Authentication auth) {
		return service.getDashboard(auth.getName());
	}
}
