package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.SpecialiteDto;
import com.forcenhopital.entities.Specialite;

@Mapper
public interface SpecialiteMapper {
    SpecialiteDto toSpecialite(Specialite specialite);
    Specialite fromSpecialite(SpecialiteDto specialiteDto);
}
