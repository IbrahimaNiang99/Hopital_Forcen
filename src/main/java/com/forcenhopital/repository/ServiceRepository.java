package com.forcenhopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{
    
}
