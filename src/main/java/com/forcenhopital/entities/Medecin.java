package com.forcenhopital.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;

    @Column(length = 40, nullable = false)
    private String prenom;

    @Column(length = 20, nullable = false)
    private String nom;

    @Column(length = 40, nullable = false)
    private Date dateDeNaissance;

    @Column(length = 40, nullable = false)
    private String lieuDeNaissance;

    @Column(length = 20, nullable = false)
    private int age;

    @Column(length = 15, nullable = false)
    private String sexe;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String nationalite;

    @Column(length = 40, nullable = false)
    private String telPersonnel;

    @Column(length = 40, nullable = false)
    private String telTravail;

    @ManyToMany
    @JoinTable(name = "medecin_specialite",
        joinColumns = @JoinColumn(name = "medecin_id"),
        inverseJoinColumns = @JoinColumn(name = "specialite_id"))
    private Set<Specialite> specialites = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "medecin_service",
        joinColumns = @JoinColumn(name = "medecin_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services = new HashSet<>();


    @OneToMany(mappedBy="medecin")
    private Set<Consultation> consultations;
    
}
