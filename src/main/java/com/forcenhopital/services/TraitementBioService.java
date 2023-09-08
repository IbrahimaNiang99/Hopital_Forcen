package com.forcenhopital.services;

import com.forcenhopital.dto.ExamenBiologiqueDto;
import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.mapping.ExamenBioMapper;
import com.forcenhopital.mapping.HospitalisationMapper;
import com.forcenhopital.repository.ExamenBioRepository;
import com.forcenhopital.repository.HospitalisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TraitementBioService {

    private final ExamenBioRepository examenBioRepository;
    private final ExamenBioMapper examenBioMapper;
    private final HospitalisationMapper hospitalisationMapper;
    private final HospitalisationRepository hospitalisationRepository;

    public TraitementBioService(ExamenBioRepository examenBioRepository, ExamenBioMapper examenBioMapper, HospitalisationMapper hospitalisationMapper, HospitalisationRepository hospitalisationRepository) {
        this.examenBioRepository = examenBioRepository;
        this.examenBioMapper = examenBioMapper;
        this.hospitalisationMapper = hospitalisationMapper;
        this.hospitalisationRepository = hospitalisationRepository;
    }

    // Controle de saisie
    public void controleDeChamps(ExamenBiologiqueDto examenBiologiqueDto){
        if (
                examenBiologiqueDto.getDesignation() == null || examenBiologiqueDto.getDesignation().isEmpty() ||
                        examenBiologiqueDto.getResultatExamen() == null || examenBiologiqueDto.getResultatExamen().isEmpty() ||
                        examenBiologiqueDto.getDateTraitement() == null ||
                        examenBiologiqueDto.getPrix() <= 1000
        ){
            throw new RuntimeException("Tous les champs sont obligatoires");
        }
    }


    // Recuperer la liste des EXAMEN_BIO
    public List<ExamenBiologiqueDto> liste(){
        return StreamSupport.stream(examenBioRepository.findAll().spliterator(), false)
                .map(examenBioMapper::toExamenBiologique)
                .collect(Collectors.toList());
    }

    // recuperer un  EXAMEN_BIO grace à son identifiant
    public ExamenBiologiqueDto  get(Long id){
        return examenBioMapper.toExamenBiologique(examenBioRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("ce traitement biologique n'existe pas")));
    }

    // Ajouter EXAMEN_BIO
    public ExamenBiologiqueDto ajout(ExamenBiologiqueDto examenBiologiqueDto, Long idHospitalisation){
        controleDeChamps(examenBiologiqueDto);
        try {
            HospitalisationDto hospitalisation = hospitalisationMapper.toHospitalisation(hospitalisationRepository.findById(idHospitalisation)
                    .orElseThrow( () -> new EntityNotFoundException("Cette hospitalisation n'existe pas") ));
            examenBiologiqueDto.setHospitalisation(hospitalisation);

            return examenBioMapper.toExamenBiologique(examenBioRepository.save(examenBioMapper.fromExamenBiologique(examenBiologiqueDto)));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
