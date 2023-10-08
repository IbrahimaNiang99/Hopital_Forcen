package com.forcenhopital.services;

import com.forcenhopital.dto.ChambreDto;
import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.mapping.ChambreMapper;
import com.forcenhopital.mapping.ServiceMapper;
import com.forcenhopital.repository.ChambreRepository;
import com.forcenhopital.repository.ServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ChambreService {
    private final ChambreRepository chambreRepository;
    private final ChambreMapper chambreMapper;

   // private final ServiceDto serviceDto;
    private final ServiceMapper serviceMapper;
    private final ServiceRepository serviceRepository;

    public ChambreService(ChambreRepository chambreRepository, ChambreMapper chambreMapper,
                          ServiceMapper serviceMapper, ServiceRepository serviceRepository) {
        this.chambreRepository = chambreRepository;
        this.chambreMapper = chambreMapper;
       // this.serviceDto = serviceDto;
        this.serviceMapper = serviceMapper;
        this.serviceRepository = serviceRepository;
    }

    //Controle de saisie
   /* public void controleDeSaisie(ChambreDto chambreDto){
        if (
                chambreDto.getCapacite() <= 0 ||
                chambreDto.getDescription() == null || chambreDto.getDescription().isEmpty() ||
                chambreDto.getPrix() <= 1000 ||
                chambreDto.getEtage() < 0
        ){
            throw new RuntimeException("Veuiller renseigner tous les champs");
        }
    }*/

    // Ajouter une chambre pour un service
    public ChambreDto ajout(ChambreDto chambreDto){

        //controleDeSaisie(chambreDto);

        try {
            ServiceDto service = chambreDto.getService();
            ServiceDto newService = serviceMapper.toService(serviceRepository.save(serviceMapper.fromService(service)));

            System.out.print(newService);
            chambreDto.setService(newService);
            System.out.print(chambreDto);
            return chambreMapper.toChambre(chambreRepository.save(chambreMapper.fromChambre(chambreDto)));

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    // Lister les chambres
    public List<ChambreDto> liste(){
        return StreamSupport.stream(chambreRepository.findAll().spliterator(), false)
                .map(chambreMapper::toChambre)
                .collect(Collectors.toList());
    }
}
