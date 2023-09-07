package com.forcenhopital.entities;

import java.util.List;
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
public class Provenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProvenance;

    @Column(length = 50, nullable = false)
    private String lieuDeProvenance;

    @OneToMany(mappedBy = "provenance")
    private List<Patient> patient;
}