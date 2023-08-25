package com.forcenhopital.dto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CHIRURGIE")
public class ChirurgieDto extends TraitementDto{

    @NotNull(message = "Veuillez entrer le nom et le prenom du chirurgien")
    private String chirurgien;

    @NotNull(message = "Veuillez entrer la description de l'anestesie")
    private String anestesie;

}
