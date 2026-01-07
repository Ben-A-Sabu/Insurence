package com.insurance.vehicle.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.vehicle.dto.RtoResponseDto;
import com.insurance.vehicle.dtoMappers.RtoMapper;
import com.insurance.vehicle.entity.RTO;
import com.insurance.vehicle.exception.InvalidRequestException;
import com.insurance.vehicle.exception.ResourceNotFoundException;
import com.insurance.vehicle.repository.RtoRepository;

@Service
public class RtoService {

    private final RtoRepository rtoRepository;

    public RtoService(RtoRepository rtoRepository) {
        this.rtoRepository = rtoRepository;
    }

    public List<RtoResponseDto> getAllActiveRtos() {
        return rtoRepository.findByIsActiveTrue()
                .stream()
                .map(RtoMapper::toDto)
                .toList();
    }

    public List<RtoResponseDto> getRtosByState(String stateCode) {

        if (stateCode == null || stateCode.length() != 2) {
            throw new InvalidRequestException("Invalid state code");
        }

        List<RtoResponseDto> result = rtoRepository
                .findByStateCodeAndIsActiveTrue(stateCode)
                .stream()
                .map(RtoMapper::toDto)
                .toList();

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("No RTOs found for state " + stateCode);
        }

        return result;
    }

    public RTO getRtoById(Long id) {
        return rtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RTO not found"));
    }
}
