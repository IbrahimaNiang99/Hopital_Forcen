package com.forcenhopital.controller;

import com.forcenhopital.dto.ChirurgieDto;
import com.forcenhopital.dto.ExamenBiologiqueDto;
import com.forcenhopital.dto.ExamenRadiologieDto;
import com.forcenhopital.services.TraitementBioService;
import com.forcenhopital.services.TraitementChirurgieService;
import com.forcenhopital.services.TraitementRadioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traitement")
public class TraitementController {
    private final TraitementBioService traitementBioService;
    private final TraitementRadioService traitementRadioService;
    private final TraitementChirurgieService traitementChirurgieService;

    public TraitementController(TraitementBioService traitementBioService,
                                TraitementRadioService traitementRadioService,
                                TraitementChirurgieService traitementChirurgieService) {
        this.traitementBioService = traitementBioService;
        this.traitementRadioService = traitementRadioService;
        this.traitementChirurgieService = traitementChirurgieService;
    }

    // Liste traitement chirurgique
    @GetMapping("/chirurgie/liste")
    public List<ChirurgieDto> listetraitementChirurgie(){
        return traitementChirurgieService.listeChirurgie();
    }

    // Ajouter un traitement chirurgique
    @PostMapping("/chirurgie/ajout/{idHospitalisation}")
    public ChirurgieDto ajoutChirurgie(@Valid @RequestBody ChirurgieDto chirurgieDto, @PathVariable Long idHospitalisation){
        return traitementChirurgieService.ajout(chirurgieDto, idHospitalisation);
    }

    // Recuperer un traitement chirurgique byId
    @GetMapping("/chirurgie/getById/{id}")
    public ChirurgieDto getById(@PathVariable Long id){
        return traitementChirurgieService.get(id);
    }


    /*
    -----------------------------------------------------------------------------------------------------------------------------------------
     */


    // Liste traitement biologique
    @GetMapping("/bio/liste")
    public List<ExamenBiologiqueDto> listetraitementBiologique(){
        return traitementBioService.liste();
    }

    // Ajouter un traitement BIOLOGIQUE
    @PostMapping("/bio/ajout/{idHospitalisation}")
    public ExamenBiologiqueDto ajoutBio(@Valid @RequestBody ExamenBiologiqueDto examenBiologiqueDto, @PathVariable Long idHospitalisation){
        return traitementBioService.ajout(examenBiologiqueDto, idHospitalisation);
    }

    // Recuperer un traitement BIOLOGIQUE byId
    @GetMapping("/bio/getById/{id}")
    public ExamenBiologiqueDto getBioById(@PathVariable Long id){
        return traitementBioService.get(id);
    }


    /*
    -----------------------------------------------------------------------------------------------------------------------------------------
     */


    // Liste traitement Radiologique
    @GetMapping("/radio/liste")
    public List<ExamenRadiologieDto> listetraitementRadiologique(){
        return traitementRadioService.liste();
    }

    // Ajouter un traitement Radiologique
    @PostMapping("/radio/ajout/{idHospitalisation}")
    public ExamenRadiologieDto ajoutRadio(@Valid @RequestBody ExamenRadiologieDto examenRadiologieDto, @PathVariable Long idHospitalisation){
        return traitementRadioService.ajout(examenRadiologieDto, idHospitalisation);
    }

    // Recuperer un traitement Radiologique byId
    @GetMapping("/radio/getById/{id}")
    public ExamenRadiologieDto getRadioById(@PathVariable Long id){
        return traitementRadioService.getById(id);
    }

}
