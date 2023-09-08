package com.forcenhopital.services;

import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.dto.TraitementDto;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.mapping.HospitalisationMapper;
import com.forcenhopital.mapping.TraitementMapper;
import com.forcenhopital.repository.HospitalisationRepository;
import com.forcenhopital.repository.TraitementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service

public class TraitementService {
    private final TraitementMapper traitementMapper;
    private final TraitementRepository traitementRepository;
    private final HospitalisationRepository hospitalisationRepository;
    private final HospitalisationMapper hospitalisationMapper;

    public TraitementService(TraitementMapper traitementMapper, TraitementRepository traitementRepository, HospitalisationRepository hospitalisationRepository, HospitalisationMapper hospitalisationMapper) {
        this.traitementMapper = traitementMapper;
        this.traitementRepository = traitementRepository;
        this.hospitalisationRepository = hospitalisationRepository;
        this.hospitalisationMapper = hospitalisationMapper;
    }

    public void controleDeSaisie(TraitementDto traitementDto){
        if (
                traitementDto.getDateTraitement() == null
        ){
            throw new RuntimeException("Veiller remplir tous les chmps");
        }
    }

    // Ajouter un traitement
    public TraitementDto ajout(TraitementDto traitementDto, Long idHospitalisation){

        controleDeSaisie(traitementDto);

        try {
            HospitalisationDto hospi = hospitalisationMapper.toHospitalisation(hospitalisationRepository.findById(idHospitalisation)
                    .orElseThrow( () -> new EntityNotFoundException("Cette hospitalisation n'existe pas")));
            return traitementDto;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<TraitementDto> liste(){
        return StreamSupport.stream(traitementRepository.findAll().spliterator(), false)
                .map(traitementMapper::toTraitement)
                .collect(Collectors.toList());
    }
}
