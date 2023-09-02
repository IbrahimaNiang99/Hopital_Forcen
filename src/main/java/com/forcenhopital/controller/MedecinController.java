package com.forcenhopital.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forcenhopital.dto.MedecinDto;
import com.forcenhopital.entities.Medecin;
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
    public ResponseEntity<Object> ajout(@Valid @RequestBody MedecinDto medecinDto){
        try {
            MedecinDto medecin = medecinService.ajoutMedecin(medecinDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(medecin);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/liste")
    public List<MedecinDto> liste(){
        return medecinService.listeMedecin();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable Long id){
        Medecin medecin = medecinService.getMedecinById(id);
        return ResponseEntity.ok(medecin);
    }

    @PutMapping("/{idMedecin}/service/{idService}")
    public Medecin addServiceToMedecin(@PathVariable Long idMedecin, @PathVariable Long idService){
        return medecinService.addServiceToMedecin(idMedecin, idService);
    }

    @PutMapping("/{idMedecin}/specialite/{idSpecialite}")
    public Medecin addSpecialiteToMedecin(@PathVariable Long idMedecin, @PathVariable Long idSpecialite){
        return medecinService.addSpecialiteToMedecin(idMedecin, idSpecialite);
    }

}
