package com.insurance.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

	public Profile(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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