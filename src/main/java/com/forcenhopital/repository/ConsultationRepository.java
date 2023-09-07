package com.forcenhopital.repository;

import com.forcenhopital.dto.ConsultationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Consultation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
    @Query("select c from Consultation c where c.patient.idPatient = ?1")
    Set<ConsultationDto> listConsultationByPatient(Long id);
}
