package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    
}
