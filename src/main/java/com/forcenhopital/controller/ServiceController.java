package com.forcenhopital.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.entities.Medecin;
import com.forcenhopital.entities.ServiceEntity;
import com.forcenhopital.repository.ServiceRepository;
import com.forcenhopital.services.ServiceService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/service")
public class ServiceController {
    
    private final ServiceService serviceService;
    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceService serviceService, ServiceRepository serviceRepository) {
		this.serviceService = serviceService;		
        this.serviceRepository = serviceRepository;

	}

    @GetMapping("/liste")
	public List<ServiceDto> liste(){
        return serviceService.listeService();
    }

    @GetMapping("/test")
	public List<ServiceEntity> listeTest(){
        return serviceRepository.findAll();
    }

    @PostMapping("/ajout")
    public ResponseEntity<ServiceDto> ajout(@Valid @RequestBody ServiceDto serviceDto){
        ServiceDto service = serviceService.ajoutService(serviceDto);
        return ResponseEntity.ok(service);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ServiceEntity> getServiceById(@PathVariable Long id){
        ServiceEntity serviceEntity = serviceService.getServiceById(id);
        return ResponseEntity.ok(serviceEntity);
    }
}
