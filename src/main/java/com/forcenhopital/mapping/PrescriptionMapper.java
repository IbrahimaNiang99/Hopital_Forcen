package com.forcenhopital.mapping;

import org.mapstruct.Mapper;

import com.forcenhopital.dto.PrescriptionDto;
import com.forcenhopital.entities.Prescription;

@Mapper
public interface PrescriptionMapper {
    PrescriptionDto toPrescription(Prescription prescription);
    Prescription fromPrescription(PrescriptionDto prescriptionDto);
}
