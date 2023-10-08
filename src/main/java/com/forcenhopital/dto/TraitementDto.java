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
    private Date dateTraitement;
    private int prix;
    private Long idHospitalisation;

    private String chirurgien;
    private String anestesie;

    private String designation;
    private String resultatExamen;
}
