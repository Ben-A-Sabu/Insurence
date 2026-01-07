package com.insurance.vehicle.dto;



public class RtoResponseDto {
	

    private Long id;          // REQUIRED (hidden in UI, used internally)
    private String rtoCode;   // "KL-19"
    private String stateCode; // "KL"
    private String stateName; // "Kerala"
    private String city;      // "Ernakulam"

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRtoCode() {
		return rtoCode;
	}

	public void setRtoCode(String rtoCode) {
		this.rtoCode = rtoCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    

}
