package com.insurance.vehicle.dto;



public class RtoRiskDto {

    private Long rtoId;
    private Double riskMultiplier;

    public Long getRtoId() {
        return rtoId;
    }

    public void setRtoId(Long rtoId) {
        this.rtoId = rtoId;
    }

    public Double getRiskMultiplier() {
        return riskMultiplier;
    }

    public void setRiskMultiplier(Double riskMultiplier) {
        this.riskMultiplier = riskMultiplier;
    }
}
