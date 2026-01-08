package com.insurance.vehicle.controller;

import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.insurance.vehicle.constants.FuelType;
import com.insurance.vehicle.dto.VariantResponseDto;
import com.insurance.vehicle.services.VariantService;

@RestController
@RequestMapping("/api/variants")
public class VariantController {

    private final VariantService variantService;

    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @GetMapping
    public List<VariantResponseDto> getVariants(
            @RequestParam Long modelId,
            @RequestParam FuelType fuelType) {

        return variantService.getVariantsByModelAndFuel(modelId, fuelType);
    }

    @GetMapping("/fuel-types/{modelId}")
    public List<FuelType> getFuelTypes(@PathVariable Long modelId) {
        return variantService.getFuelTypesByModel(modelId);
    }
}
