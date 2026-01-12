package com.insurance.vehicle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rtoDetails")
public class RTO {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rto_code", unique = true, nullable = false)
    private String rtoCode;

    @Column(name = "state_code", nullable = false)
    private String stateCode;

    @Column(name = "state_name", nullable = false)
    private String stateName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "risk_multiplier")
    private Double premiumMultiplier;
    

	public Long getId() {
		return id;
	}



	public String getRtoCode() {
		return rtoCode;
	}



	public String getStateCode() {
		return stateCode;
	}



	public String getStateName() {
		return stateName;
	}



	public String getCity() {
		return city;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public Double getPremiumMultiplier() {
		return premiumMultiplier;
	}
   
	

}
