package com.forcenhopital.dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamenBiologiqueDto extends TraitementDto{

   // @NotNull(message = "Veuillez entrer la designation")
    private String designation;

    //@NotNull(message = "Veuillez entrer le resultat de l'examen")
    private String resultatExamen;

}
