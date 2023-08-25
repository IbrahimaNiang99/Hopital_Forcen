package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.ChambreDto;
import com.forcenhopital.entities.Chambre;

@Mapper
public interface ChambreMapper {
    ChambreDto toChambre(Chambre chambre);
    Chambre fromChambre(ChambreDto chambreDto);
}
