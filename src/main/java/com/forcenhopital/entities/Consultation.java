package com.forcenhopital.entities;

import java.util.Date;


import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "codeRDV", referencedColumnName = "codeRDV")
    private RendezVous rendezVouses;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}
