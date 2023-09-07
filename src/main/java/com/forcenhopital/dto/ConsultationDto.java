package com.forcenhopital.dto;

import java.util.Date;

import com.forcenhopital.entities.*;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto {

    private Long idConsultation;

    @NotNull(message = "Veuillez entrer la date de consultation")
    private Date dateConsultation;

    @NotNull(message = "Veuillez entrer la synthèse")
    private String synthese;

    @NotNull(message = "Veuillez indiquer le medecin")
    private MedecinDto medecin;

    @NotNull(message = "Donner le type de consultation")
    private TypeConsultationDto typeConsultation;

    @Nullable
    private RendezVousDto rendezVouses;

    @NotNull(message = "Donner le type de prescription")
    private PrescriptionDto prescription;

    @NotNull(message = "Indiquer le patient")
    private PatientDto patient;

}
