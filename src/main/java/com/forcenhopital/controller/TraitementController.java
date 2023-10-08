package com.forcenhopital.controller;

import com.forcenhopital.services.TraitementService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/traitement")
public class TraitementController {
    private final TraitementService traitementService;
    public TraitementController(TraitementService traitementService) {
        this.traitementService = traitementService;
    }
/*
    // Liste traitement chirurgique
    @GetMapping("/chirurgie/liste")
    public List<TraitementDto> listetraitementChirurgie(){
        return traitementChirurgieService.listeChirurgie();
    }

    */
}
