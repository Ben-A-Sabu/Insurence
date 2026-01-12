package com.insurance.vehicle.services;


import org.springframework.stereotype.Service;

import com.insurance.vehicle.dto.BrandResponseDto;
import com.insurance.vehicle.dto.BrandRiskDto;
import com.insurance.vehicle.dtoMappers.BrandMapper;
import com.insurance.vehicle.dtoMappers.BrandRiskMapper;
import com.insurance.vehicle.exception.InvalidRequestException;
import com.insurance.vehicle.exception.ResourceNotFoundException;
import com.insurance.vehicle.repository.BrandRepository;
import java.util.List;


@Service
public class BrandService {

    private final BrandRepository brandRepository;
    
    

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandResponseDto> getAllBrnads() {

        List<BrandResponseDto> brands = brandRepository.findAll()
            .stream()
            .map(BrandMapper::toDto)
            .toList();

        if (brands.isEmpty()) {
            throw new ResourceNotFoundException("Brand not found");
        }

        return brands;
    }

    
    //=================== For insurer to get the mulitpler =======================
    public BrandRiskDto getBrandRiskById(Long brandId) {

        return brandRepository.findById(brandId)
                .map(BrandRiskMapper::toRiskDto)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Brand Risk not found for id: " + brandId)
                );
    }

    
    
    public BrandResponseDto getBrandById(Long id) {
        return brandRepository.findById(id)
                .map(BrandMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
    }

    public BrandResponseDto getBrandByName(String name) {

        if (name == null || name.isBlank()) {
            throw new InvalidRequestException("Brand name cannot be empty");
        }

        return brandRepository.findByNameIgnoreCase(name)
                .map(BrandMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
    }
}

