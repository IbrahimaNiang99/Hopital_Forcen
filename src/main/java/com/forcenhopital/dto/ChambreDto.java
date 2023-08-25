package com.forcenhopital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChambreDto {

    private Long idChambre;

    @NotNull(message = "Veuillez entrer le numéro de l'étage")
    private int etage;
    
    @NotNull(message = "Veuillez entrer la description")
    private String description;

    @NotNull(message = "Veuillez entrer la capacite de la chambre")
    private int capacite;

    @NotNull(message = "Veuillez entrer le prix de la chambre")
    private int prix;

    
}
