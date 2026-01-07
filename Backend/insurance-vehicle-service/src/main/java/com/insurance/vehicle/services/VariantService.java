package com.insurance.vehicle.services;

import java.util.List;

import com.insurance.vehicle.constants.FuelType;
import com.insurance.vehicle.dto.VariantResponseDto;
import com.insurance.vehicle.dtoMappers.VariantDtoMapper;
import com.insurance.vehicle.repository.VariantRepository;

public class VariantService {
	
	   private final VariantRepository variantRepository;
	   
		public VariantService(VariantRepository variantRepository) {
			super();
			this.variantRepository = variantRepository;
		}



	    public List<VariantResponseDto> getVariantsByModelIdAndFuelType(
	            Long modelId,
	            FuelType fuelType) {

	        return variantRepository.findByModelIdAndFuelType(modelId, fuelType)
	                .stream()
	                .map(VariantDtoMapper::toDto)
	                .toList();
	    }


	    public List<FuelType> getFuelTypesByModelId(Long modelId) {

	        return variantRepository.findFuelTypesByModelId(modelId);
	    }
	

}
