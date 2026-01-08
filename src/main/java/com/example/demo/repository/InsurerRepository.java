package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Insurer;

public interface InsurerRepository extends JpaRepository<Insurer, Long> {}
