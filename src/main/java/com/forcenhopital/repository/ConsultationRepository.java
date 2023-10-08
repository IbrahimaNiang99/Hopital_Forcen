package com.forcenhopital.repository;

import com.forcenhopital.dto.ConsultationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Consultation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
    @Query("select count(*) from Consultation")
    int countConsultation();
}
