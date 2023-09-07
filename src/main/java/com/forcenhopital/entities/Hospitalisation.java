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
public class Hospitalisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmission;

    @Column(length = 20, nullable = false)
    private Date dateAdmission;

    @Column(length = 50, nullable = false)
    private String typeAdmission;

    @Column(nullable = false)
    private String motifAdmission;

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

    @OneToMany(mappedBy = "hospitalisation")
    private List<Traitement> traitement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facture_id", referencedColumnName = "idFacture")
    private Facture facture;

    /*
    * @OneToOne(mappedBy = "facture")
    private Hospitalisation hospitalisation;
    * */

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;
}
