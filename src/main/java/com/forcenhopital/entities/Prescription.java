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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrescription;

    @Column(length = 20, nullable = false)
    private String nomPatient;

    @Column(length = 50, nullable = false)
    private String prenomPatient;

    @Column(length = 20, nullable = false)
    private Date datePrescription;

   // @Column(nullable = false)
    private String note;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private Set<Consultation> consultation;
}
