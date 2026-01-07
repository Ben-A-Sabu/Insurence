
package com.insurance.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.user.entity.Profile;

@Repository
public interface UserRepository extends JpaRepository<Profile, Long> {
    boolean existsByEmail(String email);
}
