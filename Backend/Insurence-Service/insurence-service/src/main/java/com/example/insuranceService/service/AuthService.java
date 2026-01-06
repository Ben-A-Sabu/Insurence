package com.example.insuranceService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.insuranceService.dto.LoginRequestDto;
import com.example.insuranceService.dto.LoginResponseDto;
import com.example.insuranceService.entity.Insurer;
import com.example.insuranceService.repository.InsurerRepository;
import com.example.insuranceService.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private InsurerRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder encoder;

    public LoginResponseDto login(LoginRequestDto dto) {
        Insurer insurer = repo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid login"));

        if (!encoder.matches(dto.getPassword(), insurer.getPassword())) {
            throw new RuntimeException("Invalid login");
        }

        String token = jwtUtil.generate(insurer.getEmail(), "INSURER");
        return new LoginResponseDto(token);
    }
}
