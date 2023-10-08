package com.forcenhopital.services;

import com.forcenhopital.dto.ConsultationDto;
import com.forcenhopital.dto.PatientDto;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.mapping.PatientMapper;
import com.forcenhopital.repository.ConsultationRepository;
import com.forcenhopital.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final ConsultationRepository consultationRepository;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.consultationRepository = consultationRepository;
    }

    // Controller les champs de saisies
    public void controleDeChampDeSaisie(PatientDto patientDto){
        if (
                patientDto.getPrenom() == null || patientDto.getPrenom().isEmpty() ||
                patientDto.getNom() == null || patientDto.getNom().isEmpty() ||
                patientDto.getAdresse() == null || patientDto.getAdresse().isEmpty() ||
                patientDto.getSexe() == null || patientDto.getSexe().isEmpty() ||
                patientDto.getDateNaissance() == null ||
                patientDto.getPrenomMere() == null || patientDto.getPrenomMere().isEmpty() ||
                patientDto.getNomMere() == null || patientDto.getNomMere().isEmpty() ||
                patientDto.getPrenomPere() == null || patientDto.getPrenomPere().isEmpty() ||
                patientDto.getNomPere() == null || patientDto.getNomPere().isEmpty() ||
                patientDto.getNomPersonneAPrevenir() == null || patientDto.getNomPersonneAPrevenir().isEmpty() ||
                patientDto.getSituationMatrimaniale() == null || patientDto.getSituationMatrimaniale().isEmpty() ||
                patientDto.getTelephone() == null || patientDto.getTelephone().isEmpty() ||
                patientDto.getProvenance() == null
        ){
            throw new RuntimeException("Veuillez renseigner tous les champs du medecin");
        }
    }

    // Liste des patients
    public List<PatientDto> liste(){
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .map(patientMapper::toPatient)
                .collect(Collectors.toList());
    }

    public PatientDto getPatientById(Long idPatient) {

        return patientMapper.toPatient(patientRepository.findById((idPatient))
                .orElseThrow(() -> new EntityNotFoundException("Il n'existe pas de patient d'id = " + idPatient)));
    }
/*
    // find patientBy ib
    public PatientDto getPatientById(Long idPatient){

        PatientDto patientDto = patientMapper.toPatient(patientRepository.findById((idPatient))
                .orElseThrow(()-> new EntityNotFoundException("Il n'existe pas de patient d'id = "+idPatient)));

        Set<ConsultationDto> consultationDtos = ""
                //= consultationRepository.listConsultationByPatient(patientDto.getIdPatient());

        patientDto.setConsultation(consultationDtos);
        System.out.println(patientDto.getConsultation());
        return patientDto;
    }*/
}
