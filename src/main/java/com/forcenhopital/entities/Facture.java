package com.forcenhopital.entities;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    @Column(length = 20, nullable = false)
    private Date dateFacture;

    @Column(length = 20, nullable = false)
    private int totalFacture;

    @OneToOne(mappedBy = "facture")
    private Hospitalisation hospitalisation;
}
