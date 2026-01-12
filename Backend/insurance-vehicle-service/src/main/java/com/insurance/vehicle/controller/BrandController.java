package com.insurance.vehicle.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.insurance.vehicle.dto.BrandResponseDto;
import com.insurance.vehicle.services.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    
    @GetMapping
    public List<BrandResponseDto> getAllBrands()
    {
    	return brandService.getAllBrnads();
    	
    }

    @GetMapping("/{id}")
    public BrandResponseDto getById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @GetMapping("/name/{name}")
    public BrandResponseDto getByName(@PathVariable String name) {
        return brandService.getBrandByName(name);
    }
}
