package com.forcenhopital.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@DiscriminatorValue("EXAMEN_BIOLOGIQUE")
public class ExamenBiologique extends Traitement{

    private String designation;

    private String resultatExamen;

}
