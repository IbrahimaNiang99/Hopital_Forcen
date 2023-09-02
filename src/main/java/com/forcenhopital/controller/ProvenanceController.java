package com.forcenhopital.controller;

import com.forcenhopital.dto.ProvenanceDto;
import com.forcenhopital.entities.Provenance;
import com.forcenhopital.services.ProvenanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provenance")
public class ProvenanceController {
    private final ProvenanceService provenanceService;

    public ProvenanceController(ProvenanceService provenanceService) {
        this.provenanceService = provenanceService;
    }

    @GetMapping("/liste")
    public List<ProvenanceDto> liste(){
        return provenanceService.listeProvenance();
    }

    @PostMapping("/ajout")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProvenanceDto ajout(@Valid @RequestBody ProvenanceDto provenanceDto) {
        return provenanceService.ajouter(provenanceDto);
    }

    @GetMapping("/getById/{id}")
    public ProvenanceDto getMedecinById(@PathVariable Long id){
        return provenanceService.getProvenanceById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProvenance(@PathVariable Long id){
        provenanceService.deleteProvenance(id);
    }
}
