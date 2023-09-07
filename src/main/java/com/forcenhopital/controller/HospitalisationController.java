package com.forcenhopital.controller;

import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.services.HospitalisationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalisation")
public class HospitalisationController {
    private final HospitalisationService hospitalisationService;

    public HospitalisationController(HospitalisationService hospitalisationService) {
        this.hospitalisationService = hospitalisationService;
    }
    @GetMapping("/liste")
    public List<HospitalisationDto> liste(){
        return hospitalisationService.liste();
    }

    @GetMapping("/getById/{id}")
    public HospitalisationDto getById(@PathVariable Long id){
        return hospitalisationService.getById(id);
    }

    @PostMapping("/ajout/{idPatient}/chambre/{idChambre}")
    public HospitalisationDto ajout(@Valid @RequestBody HospitalisationDto hospitalisationDto, @PathVariable Long idPatient, @PathVariable Long idChambre){
        return hospitalisationService.ajout(hospitalisationDto, idPatient, idChambre);
    }


}
