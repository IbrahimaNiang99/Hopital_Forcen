package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Specialite;

public interface SpecialisteRepository extends JpaRepository<Specialite, Long> {
    
}
