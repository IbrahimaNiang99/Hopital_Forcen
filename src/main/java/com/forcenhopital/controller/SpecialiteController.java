package com.forcenhopital.controller;

import java.util.List;

import com.forcenhopital.dto.SpecialiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forcenhopital.services.SpecialiteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/specialite")
public class SpecialiteController {
    
    private final SpecialiteService specialiteService;

    @Autowired
    public SpecialiteController(SpecialiteService specialiteService){
        this.specialiteService = specialiteService;
    }

    @GetMapping("/liste")
    public List<SpecialiteDto> liste(){
        return specialiteService.listeSpecialite();
    }

    @PostMapping("/ajout")
    public ResponseEntity<Object> ajout(@RequestBody SpecialiteDto specialiteDto){
        try {
            SpecialiteDto specialiste = specialiteService.ajoutSpecialite(specialiteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(specialiste);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
        }
    }
}
