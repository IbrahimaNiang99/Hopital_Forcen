package com.forcenhopital.controller;

import com.forcenhopital.dto.RendezVousDto;
import com.forcenhopital.services.RVService;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
public class RVController {
    private final RVService rvService;

    public RVController(RVService rvService) {
        this.rvService = rvService;
    }

    @GetMapping("/liste")
    public List<RendezVousDto> liste(){
        return rvService.liste();
    }

    @PostMapping("/ajout")
    @ResponseStatus(code = HttpStatus.CREATED)
    public RendezVousDto ajout(@Valid @RequestBody RendezVousDto rendezVousDto){
        return rvService.ajout(rendezVousDto);
    }

    @GetMapping("/getRVById/{id}")
    public RendezVousDto getById(@PathVariable Long id){
        return rvService.getRvById(id);
    }
}
