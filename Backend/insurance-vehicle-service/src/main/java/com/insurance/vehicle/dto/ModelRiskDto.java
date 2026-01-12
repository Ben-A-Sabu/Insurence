package com.insurance.vehicle.dto;



public class ModelRiskDto {

    private Long modelId;
    private Double riskMultiplier;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Double getRiskMultiplier() {
        return riskMultiplier;
    }

    public void setRiskMultiplier(Double riskMultiplier) {
        this.riskMultiplier = riskMultiplier;
    }
}
