package com.forcenhopital.repository;

import com.forcenhopital.dto.HospitalisationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Hospitalisation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {

}
