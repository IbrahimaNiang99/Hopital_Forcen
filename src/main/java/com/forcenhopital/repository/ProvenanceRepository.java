package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Provenance;

public interface ProvenanceRepository extends JpaRepository<Provenance, Long> {
    
}
