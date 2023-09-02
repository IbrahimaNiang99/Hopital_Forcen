package com.forcenhopital.entities;

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
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecialite;

    @Column(length = 40, nullable = false)
    private String nomSpecialite;

    @ManyToMany(mappedBy = "specialites", fetch = FetchType.EAGER)
    private Set<Medecin> medecins = new HashSet<>();
}
