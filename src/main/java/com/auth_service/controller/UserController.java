package com.auth_service.controller;

import org.springframework.web.bind.annotation.*;

import com.auth_service.dto.LoginDto;
import com.auth_service.dto.RegisterDto;
import com.auth_service.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class UserController {
	private UserService service;
	
	public UserController(UserService service) {
		this.service=service;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterDto dto) {
		return service.register(dto);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody @Valid LoginDto dto) {
		return service.login(dto);
	}
}
