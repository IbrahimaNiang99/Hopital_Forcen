package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.ConsultationDto;
import com.forcenhopital.entities.Consultation;

@Mapper
public interface ConsultationMapper {
    ConsultationDto toConsultation(Consultation consultation);
    Consultation fromConsultation(ConsultationDto consultationDto);
    
}
