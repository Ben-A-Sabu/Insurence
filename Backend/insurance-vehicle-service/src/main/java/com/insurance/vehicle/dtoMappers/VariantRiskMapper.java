package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.VariantRiskDto;
import com.insurance.vehicle.entity.Variant;

public class VariantRiskMapper {

    public static VariantRiskDto toRiskDto(Variant variant) {
        VariantRiskDto dto = new VariantRiskDto();
        dto.setVariantId(variant.getId());
        dto.setRiskMultiplier(variant.getPremiumMultiplier());
        return dto;
    }
}