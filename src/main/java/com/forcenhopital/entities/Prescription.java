package com.forcenhopital.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "prescription")
    private Set<Consultation> consultation = new HashSet<>();;
}
