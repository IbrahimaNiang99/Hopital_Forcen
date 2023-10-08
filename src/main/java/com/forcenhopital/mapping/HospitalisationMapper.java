package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.entities.Hospitalisation;

@Mapper
public interface HospitalisationMapper {
    HospitalisationDto toHospitalisation(Hospitalisation hospitalisation);
    Hospitalisation fromHospitalisation(HospitalisationDto hospitalisationDto);
}
