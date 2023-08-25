package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Chambre;


public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    
}


