package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.BrandRiskDto;
import com.insurance.vehicle.entity.Brand;

public class BrandRiskMapper {

    public static BrandRiskDto toRiskDto(Brand brand) {
        BrandRiskDto dto = new BrandRiskDto();
        dto.setBrandId(brand.getId());
        dto.setRiskMultiplier(brand.getPremiumMultiplier());
        return dto;
    }
}