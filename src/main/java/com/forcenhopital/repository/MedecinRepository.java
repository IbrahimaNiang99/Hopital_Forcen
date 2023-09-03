package com.forcenhopital.repository;
import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forcenhopital.entities.Medecin;

import java.util.Set;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
    //Set<ServiceEntity> findAllServicesForMedecin(Long idMedecin);
}
