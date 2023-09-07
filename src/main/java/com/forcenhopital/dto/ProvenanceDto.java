package com.forcenhopital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvenanceDto {

    private Long idProvenance;

    @NotNull(message = "Veuillez entrer le lieu du provenance")
    private String lieuDeProvenance;

}