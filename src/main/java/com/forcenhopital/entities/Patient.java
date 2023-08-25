package com.forcenhopital.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    @Column(length = 40, nullable = false)
    private String prenom;

    @Column(length = 40, nullable = false)
    private String nom;

    private String age;

    @Column(length = 40, nullable = false)
    private String adresse;

    @Column(length = 20, nullable = false)
    private String situationMatrimaniale;

    @Column(length = 40, nullable = false)
    private Date dateNaissance;

    @Column(length = 20, nullable = false)
    private String telephone;

    @Column(length = 10, nullable = false)
    private String sexe;

    @Column(length = 40, nullable = false)
    private String prenomPere;

    @Column(length = 40, nullable = false)
    private String nomPere;

    @Column(length = 40, nullable = false)
    private String prenomMere;

    @Column(length = 40, nullable = false)
    private String nomMere;

    @Column(length = 20, nullable = false)
    private String telPersonneAPrevenir;

    @Column(length = 50, nullable = false)
    private String nomPersonneAPrevenir;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Consultation> consultation;

    @ManyToOne
    @JoinColumn(name = "provenance_id")
    private Provenance provenance;

    @ManyToOne
    @JoinColumn(name = "codeRDV")
    private RendezVous rendezVous;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Hospitalisation> hospitalisations;




}
