package com.forcenhopital.dto;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto {
    
    private Long idFacture;

    @NotNull(message = "Veuillez entrer la date de la facture")
    private Date dateFacture;

    @NotNull(message = "Veuillez entrer le montant de la facture")
    private int totalFacture;

}
