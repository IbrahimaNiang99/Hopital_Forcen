package com.forcenhopital.dto;
import java.util.Date;

import com.forcenhopital.entities.Facture;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalisationDto {

    private Long idAdmission;

    @NotNull(message = "Veuillez entrer a date de l'admission")
    private Date dateAdmission;

    @NotNull(message = "Veuillez entrer le type d'admission")
    private String typeAdmission;

    @NotNull(message = "Veuillez entrer le motif d'admission")
    private String motifAdmission;

    @NotNull(message = "Veuillez entrer le prenom et le nom du medecin traitant")
    private String medecinTraitant;

    @NotNull(message = "Veuillez entrer le prenom et le nom de l'accompagnant(e)")
    private String accompagnant;

    @NotNull(message = "Veuillez entrer le lien parental")
    private String lienParental;

    @NotNull(message = "Veuillez entrer la date d'entrée")
    private Date dateEntree;

    @NotNull(message = "Veuillez entrer la date de sortie")
    private Date dateSortie;

    @NotNull(message = "Veuillez entrer le motif de la sortie")
    private String motifSortie;

    @NotNull(message = "Veuillez entrer le resultat de la sortie")
    private String resultatSortie;

    //@NotNull(message = "Veuillez entrer la date du décès")
    @Nullable
    private Date dateDeces;

    //@NotNull(message = "Veuillez entrer le motif du décès")
    @Nullable
    private String motifDeces;

    //@NotNull(message = "Veuillez indiquer le patient concerné")
    private PatientDto patient;

    @NotNull(message = "Veuillez indiquer la facture")
    private FactureDto facture;

}
