package com.insurance.vehicle.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.vehicle.constants.FuelType;
import com.insurance.vehicle.dto.VariantResponseDto;
import com.insurance.vehicle.dtoMappers.VariantDtoMapper;
import com.insurance.vehicle.exception.InvalidRequestException;
import com.insurance.vehicle.exception.ResourceNotFoundException;
import com.insurance.vehicle.repository.VariantRepository;


@Service
public class VariantService {

    private final VariantRepository variantRepository;

    public VariantService(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    public List<VariantResponseDto> getVariantsByModelAndFuel(
            Long modelId, FuelType fuelType) {

        if (modelId == null || fuelType == null) {
            throw new InvalidRequestException("ModelId and fuelType are required");
        }

        List<VariantResponseDto> variants =
                variantRepository.findByModelIdAndFuelType(modelId, fuelType)
                        .stream()
                        .map(VariantDtoMapper::toDto)
                        .toList();

        if (variants.isEmpty()) {
            throw new ResourceNotFoundException("No variants found");
        }

        return variants;
    }

    public List<FuelType> getFuelTypesByModel(Long modelId) {

        List<FuelType> fuels = variantRepository.findFuelTypesByModelId(modelId);

        if (fuels.isEmpty()) {
            throw new ResourceNotFoundException("No fuel types found");
        }

        return fuels;
    }
}

