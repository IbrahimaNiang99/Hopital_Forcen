package com.forcenhopital.repository;

import com.forcenhopital.entities.Chirurgie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChirurgieRepository extends JpaRepository<Chirurgie, Long> {
}
