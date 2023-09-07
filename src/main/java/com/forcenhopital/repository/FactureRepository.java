package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Facture;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    
}
