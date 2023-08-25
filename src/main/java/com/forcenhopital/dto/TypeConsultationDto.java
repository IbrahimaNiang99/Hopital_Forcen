package com.forcenhopital.dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TypeConsultationDto {

    private Long idTypeConsultation;

    @NotNull(message = "Veuillez entrer le type de consultation")
    private String typeConsultation;

    @NotNull(message = "Veuillez entrer le prix de la consultation")
    private int prixConsultation;

   

}
