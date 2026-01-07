package com.insurance.vehicle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.insurance.vehicle.dto.RtoResponseDto;
import com.insurance.vehicle.dtoMappers.RtoMapper;
import com.insurance.vehicle.entity.RTO;
import com.insurance.vehicle.repository.RtoRepository;

@Service
public class RtoService {
	
	private RtoRepository rtoRepo;
	
	RtoService(RtoRepository repo){
		this.rtoRepo=repo;
	}
	
	
	 public List<RtoResponseDto> getAllActiveRtos() {
	        return rtoRepo.findByIsActiveTrue()
	        		.stream()
	        		.map(RtoMapper::toDto)
	        		.toList();
	        		
	    }
	 
	   public List<RtoResponseDto> getRtosByState(String stateCode) {
	        return rtoRepo.findByStateCodeAndIsActiveTrue(stateCode)
	                .stream()
	                .map(RtoMapper::toDto)
	                .toList();
	    }
	   
	   
	    public Optional<RTO> getRtoById(Long rtoId) {
	        return rtoRepo.findById(rtoId);
	    }

}
 