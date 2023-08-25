package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.RendezVous;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    
}
