package com.forcenhopital.entities;
import java.util.List;
import java.util.Set;

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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    @Column(length = 40, nullable = false)
    private int etage;

    @Column( nullable = false)
    private String description;

    @Column( nullable = false)
    private int capacite;

    @Column( nullable = false)
    private int prix;

    @OneToMany(mappedBy = "chambre")
    private List<Hospitalisation> hospitalisations;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
    
}
