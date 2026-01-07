package com.insurance.user.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class ProfileDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
     private String email;

	public ProfileDto(@NotBlank(message = "Name is required") String name,
			@Email(message = "Invalid email format") @NotBlank(message = "Email is required") String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public ProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    
}
