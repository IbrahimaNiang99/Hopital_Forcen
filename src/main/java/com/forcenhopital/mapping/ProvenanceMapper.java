package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.ProvenanceDto;
import com.forcenhopital.entities.Provenance;

@Mapper
public interface ProvenanceMapper {
    ProvenanceDto toProvenance(Provenance provenance);
    Provenance fromProvenance(ProvenanceDto provenanceDto);
}
