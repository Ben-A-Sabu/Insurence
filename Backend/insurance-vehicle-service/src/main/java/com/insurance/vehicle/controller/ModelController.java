package com.insurance.vehicle.controller;

import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.insurance.vehicle.dto.ModelResponseDto;
import com.insurance.vehicle.services.ModelService;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/brand/{brandId}")
    public List<ModelResponseDto> getByBrand(@PathVariable Long brandId) {
        return modelService.getModelsByBrandId(brandId);
    }

    @GetMapping("/{id}")
    public ModelResponseDto getById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }
}
