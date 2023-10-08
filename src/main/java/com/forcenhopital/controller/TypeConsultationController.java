package com.forcenhopital.controller;

import com.forcenhopital.dto.TypeConsultationDto;
import com.forcenhopital.services.TypeconsultationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/typeconsultation/")
public class TypeConsultationController {
    private final TypeconsultationService typeconsultationService;

    public TypeConsultationController(TypeconsultationService typeconsultationService) {
        this.typeconsultationService = typeconsultationService;
    }

    @GetMapping("liste")
    public List<TypeConsultationDto> liste(){
        return typeconsultationService.liste();
    }
}
