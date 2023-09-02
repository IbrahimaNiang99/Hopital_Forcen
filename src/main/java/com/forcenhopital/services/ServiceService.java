package com.forcenhopital.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;

import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.entities.ServiceEntity;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.exceptions.RequestException;
import com.forcenhopital.mapping.ServiceMapper;
import com.forcenhopital.repository.ServiceRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceService {
    
    private final ServiceRepository serviceRepository;
    private final  ServiceMapper serviceMapper;
    MessageSource messageSource;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository, MessageSource messageSource, ServiceMapper serviceMapper) {
		this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
		this.messageSource = messageSource;
	}
    
    // Controle deu champ nomService
    public void controleDeChampDeSaisie(ServiceDto serviceDto){
        if (
            serviceDto.getNomService() == null || serviceDto.getNomService().isEmpty()
        ) {
            throw new RuntimeException("Veuillez renseigner le nom du service !!!");
        }
    }

    // Ajouter un service
    public ServiceDto ajoutService(ServiceDto serviceDto){
        controleDeChampDeSaisie(serviceDto);

        try {
            return serviceMapper.toService(serviceRepository.save(serviceMapper.fromService(serviceDto)));

        } catch (DataAccessException e){
            throw new RuntimeException("Erreur de connexion a la base de donnees ", e);

        }catch (Exception e){
            throw new RuntimeException("Une erreur s'est produite lors de cette opération", e);
        }
    }

    
    
    // Liste des services
    public List<ServiceDto> listeService(){
        return StreamSupport.stream(serviceRepository.findAll()
                        .spliterator(), false)
                .map(serviceMapper::toService)
                .collect(Collectors.toList());
    }

    // Recuperer un service grace à son id
    public ServiceEntity getServiceById(Long id){
        return serviceRepository.findById(id).
                orElseThrow(()->
                    new EntityNotFoundException("Il n'existe de pas de service avec un id = "+id));
    }
}
