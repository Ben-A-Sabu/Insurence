package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.RtoResponseDto;
import com.insurance.vehicle.entity.RTO;

public class RtoMapper {
	
    public static RtoResponseDto toDto(RTO rto) {
        RtoResponseDto dto = new RtoResponseDto();
        dto.setId(rto.getId());
        dto.setRtoCode(rto.getRtoCode());
        dto.setStateCode(rto.getStateCode());
        dto.setStateName(rto.getStateName());
        dto.setCity(rto.getCity());
        return dto;
    }

}
