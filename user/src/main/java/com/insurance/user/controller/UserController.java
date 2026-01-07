package com.insurance.user.controller;

import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.insurance.user.DTO.ProfileDto;
import com.insurance.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    
    public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProfileDto> registerUser(
            @Valid @RequestBody ProfileDto profileDto) {

        return ResponseEntity.ok(userService.saveUser(profileDto));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getProfileById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<ProfileDto> updateProfile(
            @PathVariable Long id,
            @Valid @RequestBody ProfileDto profileDto) {

        return ResponseEntity.ok(userService.updateProfile(id, profileDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

	
    
}

