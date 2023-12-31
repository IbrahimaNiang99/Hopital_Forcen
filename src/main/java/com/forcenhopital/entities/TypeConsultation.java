package com.forcenhopital.entities;
import java.util.List;

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
public class TypeConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeConsultation;

    @Column(length = 100, nullable = false)
    private String typeConsultation;

    @Column(length = 100, nullable = false)
    private int prixConsultation;

    @OneToMany(mappedBy="typeConsultation")
    private List<Consultation> consultations ;



}
