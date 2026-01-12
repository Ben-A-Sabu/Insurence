package com.insurance.vehicle.dtoMappers;

import com.insurance.vehicle.dto.ModelRiskDto;
import com.insurance.vehicle.entity.Model;

public class ModelRiskMapper {

    public static ModelRiskDto toRiskDto(Model model) {
        ModelRiskDto dto = new ModelRiskDto();
        dto.setModelId(model.getId());
        dto.setRiskMultiplier(model.getPremiumMultiplier());
        return dto;
    }
}