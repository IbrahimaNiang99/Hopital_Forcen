package com.forcenhopital.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forcenhopital.dto.PatientDto;
import com.forcenhopital.repository.PatientRepository;
import com.forcenhopital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientService patientService, PatientRepository patientRepository) {
        this.patientService = patientService;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/liste")
    public List<PatientDto> liste(){
        return patientService.liste();
    }

    @GetMapping("/getPatientById/{id}")
    public PatientDto getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @GetMapping("/teste/{id}")
    @JsonIgnore
    public ResponseEntity<List<Object[]>> listecons(@PathVariable Long id){
        List<Object[]> data = patientRepository.liste(id);
        return ResponseEntity.ok(data);
    }

}
