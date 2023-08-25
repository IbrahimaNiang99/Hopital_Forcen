package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.ExamenRadiologieDto;
import com.forcenhopital.entities.ExamenRadiologie;

@Mapper
public interface ExamenRadioMapper {
    ExamenRadiologieDto toExamenRadiologie(ExamenRadiologie examenRadiologie);
    ExamenRadiologie fromExamenRadiologie(ExamenRadiologieDto examenRadiologieDto);
}
