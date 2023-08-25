package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Traitement;

public interface TraitementRepository extends JpaRepository<Traitement, Long> {
    
}
