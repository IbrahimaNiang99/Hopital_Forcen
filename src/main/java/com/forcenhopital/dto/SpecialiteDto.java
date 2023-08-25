package com.forcenhopital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialiteDto {

    private Long idSpecialite;

    @NotNull(message = "Veuillez entrer le nom de la spécialité")
    private String nomSpecialite;

    
}
