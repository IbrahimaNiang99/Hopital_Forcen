package com.forcenhopital.repository;

import com.forcenhopital.entities.ExamenBiologique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenBioRepository extends JpaRepository<ExamenBiologique, Long> {
}
