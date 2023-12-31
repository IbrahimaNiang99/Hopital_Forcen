package com.forcenhopital.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;

    //@Column(length = 40, nullable = false)
    private String nomService;

    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
    private List<Medecin> medecins ;

    @OneToMany(mappedBy = "service")
    private List<Chambre> chambres;
}
