package com.example.insuranceService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insurer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long insurerId;
	private String companyName;
	private String email;
	private String password;
	private String role="ROLE_INSURER";
	public long getInsurerId() {
		return insurerId;
	}
	public void setInsurerId(long insurerId) {
		this.insurerId = insurerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
