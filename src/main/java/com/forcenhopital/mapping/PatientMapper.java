package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.PatientDto;
import com.forcenhopital.entities.Patient;

@Mapper
public interface PatientMapper {
    
    PatientDto toPatient(Patient patient);
    Patient fromPatient(PatientDto patientDto);
}
