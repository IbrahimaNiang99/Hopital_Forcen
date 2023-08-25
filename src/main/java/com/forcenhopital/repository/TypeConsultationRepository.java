package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.TypeConsultation;

public interface TypeConsultationRepository extends JpaRepository<TypeConsultation, Long> {
    
}
