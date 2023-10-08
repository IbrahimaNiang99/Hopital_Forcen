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
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeRDV;

    @Column(length = 20, nullable = false)
    private Date dateRDV;

    @Column(length = 20, nullable = false)
    private String service;

    @Column(length = 150, nullable = false)
    private String medecin;

    @OneToOne(mappedBy = "rendezVouses")
    private Consultation Consultation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPatient")
    private Patient patient;

}
