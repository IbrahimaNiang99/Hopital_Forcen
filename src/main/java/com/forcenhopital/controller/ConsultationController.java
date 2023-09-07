package com.forcenhopital.controller;

import com.forcenhopital.dto.ConsultationDto;
import com.forcenhopital.services.ConsultationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {
    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/liste")
    public List<ConsultationDto> liste(){
        return consultationService.liste();
    }

    @PostMapping("/ajout/typeCons/{idTypeConsultation}/medecin/{idMedecin}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ConsultationDto ajout(@Valid @RequestBody ConsultationDto consultationDto,
                                    @PathVariable Long idTypeConsultation, @PathVariable Long idMedecin){
        return consultationService.ajout(consultationDto, idTypeConsultation, idMedecin);
    }

    @GetMapping("/getById/{id}")
    public ConsultationDto getById(@PathVariable Long id){
        return consultationService.getById(id);
    }
}
