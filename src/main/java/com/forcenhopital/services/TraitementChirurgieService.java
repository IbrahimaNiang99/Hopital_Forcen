package com.forcenhopital.services;
import com.forcenhopital.dto.ChirurgieDto;
import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.mapping.ChirurgieMapper;
import com.forcenhopital.mapping.HospitalisationMapper;
import com.forcenhopital.repository.ChirurgieRepository;
import com.forcenhopital.repository.HospitalisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TraitementChirurgieService {
    private final ChirurgieMapper chirurgieMapper;
    private final ChirurgieRepository chirurgieRepository;
    private final HospitalisationMapper hospitalisationMapper;
    private final HospitalisationRepository hospitalisationRepository;

    public TraitementChirurgieService(ChirurgieMapper chirurgieMapper, ChirurgieRepository chirurgieRepository, HospitalisationMapper hospitalisationMapper, HospitalisationRepository hospitalisationRepository) {
        this.chirurgieMapper = chirurgieMapper;
        this.chirurgieRepository = chirurgieRepository;
        this.hospitalisationMapper = hospitalisationMapper;
        this.hospitalisationRepository = hospitalisationRepository;
    }

    // Controle de saisie
    public void controleDeChamps(ChirurgieDto chirurgieDto){
        if (
                chirurgieDto.getChirurgien() == null || chirurgieDto.getChirurgien().isEmpty() ||
                        chirurgieDto.getAnestesie() == null || chirurgieDto.getAnestesie().isEmpty() ||
                        chirurgieDto.getDateTraitement() == null ||
                        chirurgieDto.getPrix() <= 1000
        ){
            throw new RuntimeException("Tous les champs sont obligatoires");
        }
    }
    public List<ChirurgieDto> listeChirurgie(){
        return StreamSupport.stream(chirurgieRepository.findAll().spliterator(), false)
                .map(chirurgieMapper::toChirurgie)
                .collect(Collectors.toList());
    }

    // Get EXAMEN_CHIRURGIE byId
    public ChirurgieDto get(Long id){
        return chirurgieMapper.toChirurgie(chirurgieRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("ce traitement n'existe pas")));
    }

    // Ajouter EXAMEN_CHIRURGIE
    public ChirurgieDto ajout(ChirurgieDto chirurgieDto, Long idHospitalisation){
        controleDeChamps(chirurgieDto);
        try {
            HospitalisationDto hospitalisation = hospitalisationMapper.toHospitalisation(hospitalisationRepository.findById(idHospitalisation)
                    .orElseThrow( () -> new EntityNotFoundException("Cette hospitalisation n'existe pas") ));
            chirurgieDto.setHospitalisation(hospitalisation);
            return chirurgieMapper.toChirurgie(chirurgieRepository.save(chirurgieMapper.fromChirurgie(chirurgieDto)));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
