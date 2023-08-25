package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Hospitalisation;


public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {
    
}
