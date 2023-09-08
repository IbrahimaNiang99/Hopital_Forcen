package com.forcenhopital.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTraitement;

    //@Column(length = 40, nullable = false)
    private Date dateTraitement;

    //@Column(length = 20, nullable = false)
    private int prix;

    @ManyToOne
    @JoinColumn(name = "Hospitalisation_id", referencedColumnName = "idAdmission")
    private Hospitalisation hospitalisation;

}
