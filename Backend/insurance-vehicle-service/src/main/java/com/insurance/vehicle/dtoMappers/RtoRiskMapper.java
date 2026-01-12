package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.RtoRiskDto;
import com.insurance.vehicle.entity.RTO;

public class RtoRiskMapper {

    public static RtoRiskDto toRiskDto(RTO rto) {
        RtoRiskDto dto = new RtoRiskDto();
        dto.setRtoId(rto.getId());
        dto.setRiskMultiplier(rto.getPremiumMultiplier());
        return dto;
    }
}
