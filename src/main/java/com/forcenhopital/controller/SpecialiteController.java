package com.forcenhopital.controller;

import java.util.List;

import com.forcenhopital.dto.SpecialiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forcenhopital.services.SpecialiteService;


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
