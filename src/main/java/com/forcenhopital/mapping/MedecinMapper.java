package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.MedecinDto;
import com.forcenhopital.entities.Medecin;

@Mapper
public interface MedecinMapper {
    MedecinDto toMedecin(Medecin medecin);
    Medecin fromMedecin(MedecinDto medecinDto);
}
