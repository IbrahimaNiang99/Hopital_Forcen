package com.forcenhopital.entities;

import java.util.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;

    @Column(length = 40, nullable = false)
    private Date dateConsultation;

    @Column( nullable = false)
    private String synthese;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "typeConsultation_id")
    private TypeConsultation typeConsultation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codeRDV", referencedColumnName = "codeRDV")
    private RendezVous rendezVouses;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}
