package com.forcenhopital.entities;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "provenance_id")
    private Provenance provenance;

    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVous;

    @OneToMany(mappedBy = "patient")
    private List<Hospitalisation> hospitalisations;




}
