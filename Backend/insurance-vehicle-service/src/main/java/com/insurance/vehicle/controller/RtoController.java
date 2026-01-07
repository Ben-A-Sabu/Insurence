package com.insurance.vehicle.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.insurance.vehicle.dto.RtoResponseDto;
import com.insurance.vehicle.services.RtoService;

@RestController
@RequestMapping("/api/rtos")
public class RtoController {

    private final RtoService rtoService;

    public RtoController(RtoService rtoService) {
        this.rtoService = rtoService;
    }

    @GetMapping
    public List<RtoResponseDto> getAllRtos() {
        return rtoService.getAllActiveRtos();
    }

    @GetMapping("/state/{stateCode}")
    public List<RtoResponseDto> getByState(@PathVariable String stateCode) {
        return rtoService.getRtosByState(stateCode);
    }
}
