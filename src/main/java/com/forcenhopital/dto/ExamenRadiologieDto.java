package com.forcenhopital.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ExamenRadiologieDto extends TraitementDto{

    private String designation;

    private String resultatExamen;
}
