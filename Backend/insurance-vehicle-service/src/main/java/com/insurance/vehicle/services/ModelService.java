package com.insurance.vehicle.services;

import com.insurance.vehicle.repository.ModelRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.vehicle.dto.ModelResponseDto;
import com.insurance.vehicle.dtoMappers.ModelMapper;
import com.insurance.vehicle.exception.InvalidRequestException;
import com.insurance.vehicle.exception.ResourceNotFoundException;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<ModelResponseDto> getModelsByBrandId(Long brandId) {

        if (brandId == null) {
            throw new InvalidRequestException("Brand id is required");
        }

        List<ModelResponseDto> models = modelRepository.findBybrandId(brandId)
                .stream()
                .map(ModelMapper::toDto)
                .toList();

        if (models.isEmpty()) {
            throw new ResourceNotFoundException("No models found for brand");
        }

        return models;
    }

    public ModelResponseDto getModelById(Long modelId) {
        return modelRepository.findById(modelId)
                .map(ModelMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Model not found"));
    }
}
