package com.insurance.vehicle.services;


import com.insurance.vehicle.dto.BrandResponseDto;
import com.insurance.vehicle.dtoMappers.BrandMapper;
import com.insurance.vehicle.repository.BrandRepository;

public class BrandService {
  
    private final BrandRepository brandRepo;

    public BrandService(BrandRepository brandRepo) {
        this.brandRepo = brandRepo;
    }

 
    public BrandResponseDto getBrandById(Long id) {
        return brandRepo.findById(id)
                .map(BrandMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }


    public BrandResponseDto getBrandByName(String name) {
        return brandRepo.findByNameIgnoreCase(name)
                .map(BrandMapper::toDto).orElseThrow(() -> new RuntimeException("Brand not found"));
    }
	
}
