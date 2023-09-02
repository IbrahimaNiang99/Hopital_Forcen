package com.forcenhopital.mapping;

import java.util.Optional;

import org.mapstruct.Mapper;
import com.forcenhopital.dto.MedecinDto;
import com.forcenhopital.entities.Medecin;

@Mapper
public interface MedecinMapper {
 
    MedecinDto toMedecin(Medecin optional);
    Medecin fromMedecin(MedecinDto medecinDto);
}
