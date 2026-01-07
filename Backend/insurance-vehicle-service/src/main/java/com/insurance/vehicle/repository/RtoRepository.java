package com.insurance.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.vehicle.entity.RTO;

public interface RtoRepository extends JpaRepository<RTO, Long> {
	

	
//	findByIsActiveTrue
//	│     │        │
//	│     │        └── Condition (TRUE)
//	│     │
//	│     └──────── Entity field name
//	│
//	└────────────── Action
	
// internally converts to SELECT * FROM rto WHERE is_active = true;	
	

	
	List<RTO> findByIsActiveTrue();
	List<RTO> findByStateCodeAndIsActiveTrue(String code);
	List<RTO> findByStateNameAndIsActiveTrue(String stateName);
	

	
	
	
	

}
