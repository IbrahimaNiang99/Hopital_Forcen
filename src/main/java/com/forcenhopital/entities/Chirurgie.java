package com.forcenhopital.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("CHIRURGIE")

public class Chirurgie extends Traitement{

    @Column(nullable = false)
    private String chirurgien;

    @Column(nullable = false)
    private String anestesie;

}
