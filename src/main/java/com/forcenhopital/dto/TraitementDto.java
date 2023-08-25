package com.forcenhopital.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraitementDto {

    private Long idTraitement;

    @NotNull(message = "Veuillez entrer la date du traitement")
    private Date dateTraitement;

    @NotNull(message = "Veuillez entrer le prix du traitement")
    private int prix;

}
