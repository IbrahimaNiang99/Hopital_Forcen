package com.forcenhopital.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeRDV;

    @Column(length = 20, nullable = false)
    private Date dateRDV;

    @Column(length = 20, nullable = false)
    private String service;

    @Column(length = 50, nullable = false)
    private String medecin;

    @OneToOne(mappedBy = "rendezVouses")
    private Consultation Consultation;

    @OneToMany(mappedBy = "rendezVous", cascade = CascadeType.ALL)
    private Set<Patient> patient;

}
