package com.forcenhopital.dto;

import java.util.Date;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVousDto {

    private Long codeRDV;

    @NotNull(message = "Veuillez entrer la date du rendez-vous")
    private Date dateRDV;

    @NotNull(message = "Veuillez entrer le nom du service")
    private String service;

    @NotNull(message = "Veuillez entrer le nom du medecin")
    private String medecin;

    private PatientDto patient;

}
