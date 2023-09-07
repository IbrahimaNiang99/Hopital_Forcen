package com.forcenhopital.services;

import com.forcenhopital.dto.FactureDto;
import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.dto.PatientDto;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.mapping.FactureMapper;
import com.forcenhopital.mapping.HospitalisationMapper;
import com.forcenhopital.mapping.PatientMapper;
import com.forcenhopital.repository.FactureRepository;
import com.forcenhopital.repository.HospitalisationRepository;
import com.forcenhopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class HospitalisationService {

    private final HospitalisationRepository hospitalisationRepository;
    private final HospitalisationMapper hospitalisationMapper;
    private final FactureMapper factureMapper;
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;
    private final FactureRepository factureRepository;

    @Autowired
    public HospitalisationService(HospitalisationRepository hospitalisationRepository, HospitalisationMapper hospitalisationMapper, FactureMapper factureMapper, PatientMapper patientMapper, PatientRepository patientRepository, FactureRepository factureRepository) {
        this.hospitalisationRepository = hospitalisationRepository;
        this.hospitalisationMapper = hospitalisationMapper;
        this.factureMapper = factureMapper;
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.factureRepository = factureRepository;
    }

    // Controle de champs de saisie
    public void controleDeChamps(HospitalisationDto hospitalisationDto){
        if (
                hospitalisationDto.getAccompagnant() == null || hospitalisationDto.getAccompagnant().isEmpty() ||
                        hospitalisationDto.getDateAdmission() == null ||
                        hospitalisationDto.getDateEntree() == null ||
                        hospitalisationDto.getMedecinTraitant() == null || hospitalisationDto.getMedecinTraitant().isEmpty() ||
                        hospitalisationDto.getLienParental() == null || hospitalisationDto.getLienParental().isEmpty() ||
                        hospitalisationDto.getMotifAdmission() == null || hospitalisationDto.getMotifAdmission().isEmpty() ||
                        hospitalisationDto.getMotifSortie() == null || hospitalisationDto.getMotifSortie().isEmpty() ||
                        hospitalisationDto.getResultatSortie() == null || hospitalisationDto.getResultatSortie().isEmpty() ||
                        hospitalisationDto.getDateSortie() == null ||
                        hospitalisationDto.getTypeAdmission() == null || hospitalisationDto.getTypeAdmission().isEmpty() ||
                        hospitalisationDto.getFacture() == null
        ){
            throw new RuntimeException("Tous les champs sont obligatoires !!!");
        }
    }

    // Nouvelle hospitalisation
    public HospitalisationDto ajout(HospitalisationDto hospitalisationDto, Long idPatient){
        controleDeChamps(hospitalisationDto);

        try {
            FactureDto facture = hospitalisationDto.getFacture();
            FactureDto newFacture = factureMapper.toFacture(factureRepository.save(factureMapper.fromFacture(facture)));

            PatientDto patient = patientMapper.toPatient(patientRepository.findById(idPatient)
                    .orElseThrow( () -> new EntityNotFoundException("Ce patient n'existe pas")));

            hospitalisationDto.setFacture(newFacture);
            hospitalisationDto.setPatient(patient);

            return hospitalisationMapper.toHospitalisation(hospitalisationRepository
                    .save(hospitalisationMapper
                            .fromHospitalisation(hospitalisationDto)));

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    // Liste des hospitalisations
    public List<HospitalisationDto> liste(){
        return StreamSupport.stream(hospitalisationRepository.findAll().spliterator(), false)
                .map(hospitalisationMapper::toHospitalisation)
                .collect(Collectors.toList());
    }

    // get Hospitalisation ById
    public HospitalisationDto getById(Long id){
        return hospitalisationMapper.toHospitalisation(hospitalisationRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Cette hospitalisation n'existe pas")));
    }

}
