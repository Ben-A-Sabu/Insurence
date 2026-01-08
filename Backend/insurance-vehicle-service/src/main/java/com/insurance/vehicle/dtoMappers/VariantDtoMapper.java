package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.VariantResponseDto;
import com.insurance.vehicle.entity.Variant;

public class VariantDtoMapper {
	
	  public static VariantResponseDto toDto(Variant variant) {
	        return new VariantResponseDto(
	                variant.getId(),
	                variant.getName(),
	                variant.getFuelType()
	        );
	    }

}
