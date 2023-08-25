package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
