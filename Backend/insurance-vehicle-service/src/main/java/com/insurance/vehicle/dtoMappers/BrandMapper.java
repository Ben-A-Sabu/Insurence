package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.BrandResponseDto;
import com.insurance.vehicle.entity.Brand;

public class BrandMapper {

    public static BrandResponseDto toDto(Brand brand) {
        BrandResponseDto dto = new BrandResponseDto();
        dto.setBrandId(brand.getId());
        dto.setBrandName(brand.getName());
        return dto;
    }
}