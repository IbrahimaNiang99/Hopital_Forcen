package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
    
}
