package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    
}
