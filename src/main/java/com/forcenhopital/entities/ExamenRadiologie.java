package com.forcenhopital.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("EXAMEN_RADIOLOGIE")
public class ExamenRadiologie extends Traitement{

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private String resultatExamen;
}
