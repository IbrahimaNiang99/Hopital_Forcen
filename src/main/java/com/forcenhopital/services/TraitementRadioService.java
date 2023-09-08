package com.forcenhopital.services;

import com.forcenhopital.dto.ExamenRadiologieDto;
import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.mapping.ExamenRadioMapper;
import com.forcenhopital.mapping.HospitalisationMapper;
import com.forcenhopital.repository.ExamenRadioRepository;
import com.forcenhopital.repository.HospitalisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TraitementRadioService {

    private final ExamenRadioRepository examenRadioRepository;
    private final ExamenRadioMapper examenRadioMapper;
    private final HospitalisationMapper hospitalisationMapper;
    private final HospitalisationRepository hospitalisationRepository;

    public TraitementRadioService(ExamenRadioRepository examenRadioRepository, ExamenRadioMapper examenRadioMapper, HospitalisationMapper hospitalisationMapper, HospitalisationRepository hospitalisationRepository) {
        this.examenRadioRepository = examenRadioRepository;
        this.examenRadioMapper = examenRadioMapper;
        this.hospitalisationMapper = hospitalisationMapper;
        this.hospitalisationRepository = hospitalisationRepository;
    }

    // Controle de saisie
    public void controleDeChamps(ExamenRadiologieDto examenRadiologieDto){
        if (
                examenRadiologieDto.getDesignation() == null || examenRadiologieDto.getDesignation().isEmpty() ||
                        examenRadiologieDto.getResultatExamen() == null || examenRadiologieDto.getResultatExamen().isEmpty() ||
                        examenRadiologieDto.getDateTraitement() == null ||
                        examenRadiologieDto.getPrix() <= 1000
        ){
            throw new RuntimeException("Tous les champs sont obligatoires");
        }
    }


    // Recuperer la liste des EXAMEN_RADIO
    public List<ExamenRadiologieDto> liste(){
        return StreamSupport.stream(examenRadioRepository.findAll().spliterator(), false)
                .map(examenRadioMapper::toExamenRadiologie)
                .collect(Collectors.toList());
    }

    // recuperer un  EXAMEN_RADIO grace à son identifiant
    public ExamenRadiologieDto  getById(Long id){
        return examenRadioMapper.toExamenRadiologie(examenRadioRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("ce traitement biologique n'existe pas")));
    }

    // Ajouter EXAMEN_RADIO
    public ExamenRadiologieDto ajout(ExamenRadiologieDto examenRadiologieDto, Long idHospitalisation){
        controleDeChamps(examenRadiologieDto);
        try {
            HospitalisationDto hospitalisation = hospitalisationMapper.toHospitalisation(hospitalisationRepository.findById(idHospitalisation)
                    .orElseThrow( () -> new EntityNotFoundException("Cette hospitalisation n'existe pas") ));
            examenRadiologieDto.setHospitalisation(hospitalisation);
            return examenRadioMapper.toExamenRadiologie(examenRadioRepository.save(examenRadioMapper.fromExamenRadiologie(examenRadiologieDto)));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
