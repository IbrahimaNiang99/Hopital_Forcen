package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.RendezVousDto;
import com.forcenhopital.entities.RendezVous;

@Mapper
public interface RendezVousMapper {
    RendezVousDto toRendezVous(RendezVous rendezVous);
    RendezVous fromRendezVous(RendezVousDto rendezVousDto);
}
