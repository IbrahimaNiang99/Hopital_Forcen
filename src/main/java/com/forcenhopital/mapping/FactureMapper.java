package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.FactureDto;
import com.forcenhopital.entities.Facture;

@Mapper
public interface FactureMapper {
    FactureDto toFacture(Facture facture);
    Facture fromFacture(FactureDto factureDto);
}
