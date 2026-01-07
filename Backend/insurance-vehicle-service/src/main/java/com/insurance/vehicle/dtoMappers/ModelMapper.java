package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.ModelResponseDto;
import com.insurance.vehicle.entity.Model;

public class ModelMapper {
	
    public static ModelResponseDto toDto(Model model) {
        ModelResponseDto modalDto=new ModelResponseDto();
        
       modalDto.setId(model.getId());
       modalDto.setName(model.getName());
       
       return modalDto;
    }

}
