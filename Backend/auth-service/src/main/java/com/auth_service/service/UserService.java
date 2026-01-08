package com.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.auth_service.dto.LoginDto;
import com.auth_service.dto.RegisterDto;
import com.auth_service.entity.User;
import com.auth_service.repository.UserRepository;
import com.auth_service.security.JwtUtil;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	public String register(RegisterDto dto) {
		if(userRepository.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		User user= new User();
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());
		
		userRepository.save(user);
		
		return "User Registered Successfylly";
	}

    public String login(LoginDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getId(), user.getRole());
    }
}

