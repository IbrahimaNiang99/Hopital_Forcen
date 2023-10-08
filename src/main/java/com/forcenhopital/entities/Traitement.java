package com.forcenhopital.entities;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTraitement;
    private Date dateTraitement;
    private int prix;
    private Long idHospitalisation;
    private String typeTraitement;

    private String chirurgien;
    private String anestesie;

    private String designation;
    private String resultatExamen;
}

