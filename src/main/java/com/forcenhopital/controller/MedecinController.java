package com.forcenhopital.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forcenhopital.dto.MedecinDto;
import com.forcenhopital.services.MedecinService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/medecin")
public class MedecinController {
    private final MedecinService medecinService;
    @Autowired
    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @PostMapping("/ajout")
    @ResponseStatus(code = HttpStatus.CREATED)
    public MedecinDto ajout(@Valid @RequestBody MedecinDto medecinDto){
       return medecinService.ajoutMedecin(medecinDto);
    }

    @GetMapping("/liste")
    public List<MedecinDto> liste(){
        return medecinService.listeMedecin();
    }

    @GetMapping("/getById/{id}")
    public MedecinDto getMedecinById(@PathVariable Long id){
        return medecinService.getMedecinById(id);
    }

    @PutMapping("/{idMedecin}/service/{idService}")
    public MedecinDto addServiceToMedecin(@PathVariable Long idMedecin, @PathVariable Long idService){
        return medecinService.addServiceToMedecin(idMedecin, idService);
    }
/*
    @PutMapping("/{idMedecin}/specialite/{idSpecialite}")
    public Medecin addSpecialiteToMedecin(@PathVariable Long idMedecin, @PathVariable Long idSpecialite){
        return medecinService.addSpecialiteToMedecin(idMedecin, idSpecialite);
    }*/

}
