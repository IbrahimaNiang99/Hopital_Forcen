package com.forcenhopital.dto;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalisationDto {
    
    private Long idHospitalisation;

    @NotNull(message = "Veuillez entrer a date de l'admission")
    private Date dateHospitalisation;

    @NotNull(message = "Veuillez entrer le type d'admission")
    private String typeHospitalisation;

    @NotNull(message = "Veuillez entrer le motif d'admission")
    private String motifHospitalisation;

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

    @NotNull(message = "Veuillez entrer la date du décès")
    private Date dateDeces;

    @NotNull(message = "Veuillez entrer le motif du décès")
    private String motifDeces;

}
