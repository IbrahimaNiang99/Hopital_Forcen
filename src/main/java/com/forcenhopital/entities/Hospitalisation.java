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
public class Hospitalisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHospitalisation;

    @Column(length = 20, nullable = false)
    private Date dateHospitalisation;

    @Column(length = 50, nullable = false)
    private String typeHospitalisation;

    @Column(nullable = false)
    private String motifHospitalisation;

    @Column(length = 50, nullable = false)
    private String medecinTraitant;

    @Column(length = 50, nullable = false)
    private String accompagnant;

    @Column(length = 50, nullable = false)
    private String lienParental;

    @Column(length = 20, nullable = false)
    private Date dateEntree;

    @Column(length = 20, nullable = false)
    private Date dateSortie;

    @Column(length = 50, nullable = false)
    private String motifSortie;

    @Column(nullable = false)
    private String resultatSortie;

    @Column(length = 20)
    private Date dateDeces;

    @Column(length = 20)
    private String motifDeces;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "hospitalisation")
    private Traitement traitement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facture_id", referencedColumnName = "idFacture")
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;
}
