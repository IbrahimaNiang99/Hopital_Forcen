package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
    
}
