package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.TraitementDto;
import com.forcenhopital.entities.Traitement;

@Mapper
public interface TraitementMapper {
    TraitementDto toTraitement(Traitement traitement);
    Traitement fromTraitement(TraitementDto traitementDto);
}
