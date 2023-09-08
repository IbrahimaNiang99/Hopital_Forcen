package com.forcenhopital.dto;

import com.forcenhopital.entities.ServiceEntity;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedecinDto {
    private Long idMedecin;
    @NotNull(message = "Veuillez entrer le prenom")
    private String prenom;

    @NotNull(message = "Veuillez entrer le nom")
    private String nom;

    @NotNull(message = "Veuillez entrer la date de naissance")
    private Date dateDeNaissance;

    @NotNull(message = "Veuillez entrer le lieu de naissance")
    private String lieuDeNaissance;

    @NotNull(message = "Veuillez entrer l'age")
    private int age;

    @NotNull(message = "Veuillez entrer le sexe")
    private String sexe;

    @NotNull(message = "Veuillez entrer l'adresse email")
    private String email;

    @NotNull(message = "Veuillez entrer la nationalite")
    private String nationalite;

    @NotNull(message = "Veuillez entrer le numéro de téléphone")
    private String telPersonnel;

    @NotNull(message = "Veuillez entrer le numéro de téléphone de la personne à prevenir")
    private String telTravail;

    //@Nullable
    private List<ServiceDto> services;

    private List<SpecialiteDto> specialites;


}
