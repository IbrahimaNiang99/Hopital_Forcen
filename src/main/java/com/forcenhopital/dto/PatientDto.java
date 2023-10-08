package com.forcenhopital.dto;

import java.util.Date;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

   private Long idPatient;

    private String prenom;

    private String nom;

    private String age;

    @NotNull(message = "donner l'adresse")
    private String adresse;

    private String situationMatrimaniale;

    private Date dateNaissance;

    private String telephone;

    private String sexe;

    private String prenomPere;

    private String nomPere;

    private String prenomMere;

    private String nomMere;

    private String telPersonneAPrevenir;

    private String nomPersonneAPrevenir ;

    private ProvenanceDto provenance;

}
