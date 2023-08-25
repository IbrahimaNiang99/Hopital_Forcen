package com.forcenhopital.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {
    private Long idPrescription;

    @NotNull(message = "Veuillez entrer le nom du patient")
    private String nomPatient;

    @NotNull(message = "Veuillez entrer le prenom du patient")
    private String prenomPatient;

    @NotNull(message = "Veuillez entrer la date de prescription")
    private Date datePrescription;

    @NotNull(message = "Veuillez entrer la note")
    private String note;
}
