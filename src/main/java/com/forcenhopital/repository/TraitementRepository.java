package com.forcenhopital.repository;

import com.forcenhopital.dto.TraitementDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Traitement;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TraitementRepository extends JpaRepository<Traitement, Long> {
}
