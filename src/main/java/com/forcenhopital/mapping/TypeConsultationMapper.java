package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.TypeConsultationDto;
import com.forcenhopital.entities.TypeConsultation;

@Mapper
public interface TypeConsultationMapper {
    TypeConsultationDto toTypeConsultation(TypeConsultation typeConsultation);
    TypeConsultation fromTypeConsultation(TypeConsultationDto typeConsultationDto);
}
