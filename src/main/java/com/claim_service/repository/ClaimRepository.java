package com.claim_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.claim_service.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>{
	
	List<Claim> findByUserId(Long userId);
	
	@Modifying
	@Query(value="CALL decide_claim(:id,:status,:reason)",nativeQuery=true)
	void decideClaim(
			@Param("id")Long id,
			@Param("status")String status,
			@Param("reason")String reason);
}
