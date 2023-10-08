package com.forcenhopital.controller;
import com.forcenhopital.payload.DossierPatientLoad;
import com.forcenhopital.services.DossierPatientService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dossier/")
public class DossierPatientController {
    private final DossierPatientService dossierPatientService;

    public DossierPatientController(DossierPatientService dossierPatientService) {
        this.dossierPatientService = dossierPatientService;
    }

    @GetMapping("getById/{id}")
    public DossierPatientLoad getObjects(@PathVariable Long id){
        return dossierPatientService.liste(id);
    }

}
