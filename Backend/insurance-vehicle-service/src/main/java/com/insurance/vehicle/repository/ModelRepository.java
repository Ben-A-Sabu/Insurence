package com.insurance.vehicle.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.vehicle.entity.Model;

public interface ModelRepository extends JpaRepository<Model,Long> {

	List<Model> findBybrandId(long brandId);

	
}
