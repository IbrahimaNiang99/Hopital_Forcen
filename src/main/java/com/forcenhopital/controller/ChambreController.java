package com.forcenhopital.controller;

import com.forcenhopital.dto.ChambreDto;
import com.forcenhopital.services.ChambreService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambre")
public class ChambreController {
    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    // Liste des chambres
    @GetMapping("/liste")
    public List<ChambreDto> liste(){
        return chambreService.liste();
    }

    // Ajoutr une chambre
    @PostMapping("/ajout")
    public ChambreDto ajout(@Valid @RequestBody ChambreDto chambreDto){
        return chambreService.ajout(chambreDto);
    }
}
