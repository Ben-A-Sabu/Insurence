package com.example.insuranceService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.insuranceService.dto.LoginRequestDto;
import com.example.insuranceService.dto.LoginResponseDto;
import com.example.insuranceService.service.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/insurer/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto dto) {
    	System.out.println("I am in login");
        return service.login(dto);
    }
}
