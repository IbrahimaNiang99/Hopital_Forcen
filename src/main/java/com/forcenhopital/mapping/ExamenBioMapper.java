package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.ExamenBiologiqueDto;
import com.forcenhopital.entities.ExamenBiologique;

@Mapper
public interface ExamenBioMapper {
    ExamenBiologiqueDto toExamenBiologique(ExamenBiologique examenBiologique);
    ExamenBiologique fromExamenBiologique(ExamenBiologiqueDto examenBiologiqueDto);
}
