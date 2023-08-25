package com.forcenhopital.dto;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConsultationDto {
    private Long idConsultation;

    @NotNull(message = "Veuillez entrer la date de consultation")
    private Date dateConsultation;

    @NotNull(message = "Veuillez entrer la synthèse")
    private String synthese;

}
