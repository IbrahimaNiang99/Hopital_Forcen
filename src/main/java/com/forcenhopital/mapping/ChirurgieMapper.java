package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.ChirurgieDto;
import com.forcenhopital.entities.Chirurgie;

@Mapper
public interface ChirurgieMapper {
    ChirurgieDto toChirurgie(Chirurgie chirurgie);
    Chirurgie fromChirurgie(ChirurgieDto chirurgieDto);
}
