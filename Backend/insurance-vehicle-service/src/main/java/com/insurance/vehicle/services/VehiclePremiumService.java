package com.insurance.vehicle.services;

import org.springframework.stereotype.Service;

import com.insurance.vehicle.dto.BrandRiskDto;
import com.insurance.vehicle.dto.ModelRiskDto;
import com.insurance.vehicle.dto.PremiumCalculationRequest;
import com.insurance.vehicle.dto.PremiumCalculationResponse;
import com.insurance.vehicle.dto.RtoRiskDto;
import com.insurance.vehicle.dto.VariantRiskDto;
import com.insurance.vehicle.dto.VehiclePremiumRequest;


@Service
public class VehiclePremiumService {

    private final RtoService rtoRiskService;
    private final BrandService brandRiskService;
    private final ModelService modelRiskService;
    private final VariantService variantRiskService;
    private final MultiplierService multiplierService;

    public VehiclePremiumService(
            RtoService rtoRiskService,
            BrandService brandRiskService,
            ModelService modelRiskService,
            VariantService variantRiskService,
            MultiplierService multiplierService) {

        this.rtoRiskService = rtoRiskService;
        this.brandRiskService = brandRiskService;
        this.modelRiskService = modelRiskService;
        this.variantRiskService = variantRiskService;
        this.multiplierService = multiplierService;
    }

    public PremiumCalculationResponse calculatePremium(VehiclePremiumRequest request) {

        // 🔥 Load risk data (multipliers only)
        RtoRiskDto rto = rtoRiskService.getRtoRiskById(request.getRtoId());
        BrandRiskDto brand = brandRiskService.getBrandRiskById(request.getBrandId());
        ModelRiskDto model = modelRiskService.getModelRiskById(request.getModelId());
        VariantRiskDto variant = variantRiskService.getVariantRiskByIdAndFuelType(request.getVariantId(), request.getFuelType());

        // 🔥 Build pricing request
        PremiumCalculationRequest calcRequest = new PremiumCalculationRequest();
        calcRequest.setRtoMultiplier(rto.getRiskMultiplier());
        calcRequest.setBrandMultiplier(brand.getRiskMultiplier());
        calcRequest.setModelMultiplier(model.getRiskMultiplier());
        calcRequest.setVariantMultiplier(variant.getRiskMultiplier());

        // 🔥 Calculate premium
        Double finalPremium = multiplierService.calculatePremium(calcRequest);

        return new PremiumCalculationResponse(finalPremium);
    }
}
