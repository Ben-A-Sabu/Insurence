package com.insurance.vehicle.services;

import com.insurance.vehicle.repository.ModelRepository;

import java.util.List;

import com.insurance.vehicle.dto.ModelResponseDto;
import com.insurance.vehicle.dtoMappers.ModelMapper;
import com.insurance.vehicle.entity.Model;

public class ModalService {
	
    private final ModelRepository modelRepository;
    
    

    
    public ModalService(ModelRepository modelRepository) {
		this.modelRepository = modelRepository;
	}


	public List<ModelResponseDto> getModelsByBrandId(Long brandId) {

        return modelRepository.findBybrandId(brandId)
                .stream()
                .map(ModelMapper::toDto)
                .toList();
    }

    
    public ModelResponseDto getModelById(Long modelId) {

        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        return ModelMapper.toDto(model);
    }

}
