package com.example.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
	@RequestMapping("/insurer") 
	public ResponseEntity<String> insureFallback() { 
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE) .body("Insurer service is down");
	}
}
