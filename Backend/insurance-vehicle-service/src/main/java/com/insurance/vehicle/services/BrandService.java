package com.insurance.vehicle.services;


import org.springframework.stereotype.Service;

import com.insurance.vehicle.dto.BrandResponseDto;
import com.insurance.vehicle.dtoMappers.BrandMapper;
import com.insurance.vehicle.exception.InvalidRequestException;
import com.insurance.vehicle.exception.ResourceNotFoundException;
import com.insurance.vehicle.repository.BrandRepository;


@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
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

