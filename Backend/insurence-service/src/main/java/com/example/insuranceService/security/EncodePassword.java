package com.example.insuranceService.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
public class EncodePassword { 
    public static void main(String[] args) 
{ 
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
    String encoded = encoder.encode("password123"); 
    System.out.println(encoded); 
    
    }
}