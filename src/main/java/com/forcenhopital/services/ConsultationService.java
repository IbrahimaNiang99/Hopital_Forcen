package com.forcenhopital.services;

import com.forcenhopital.dto.*;
import com.forcenhopital.entities.TypeConsultation;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.exceptions.RequestException;
import com.forcenhopital.mapping.*;
import com.forcenhopital.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final ConsultationMapper consultationMapper;
    private final TypeConsultationRepository typeConsultationRepository;
    private final TypeConsultationMapper typeConsultationMapper;
    private final MedecinMapper medecinMapper;
    private final MedecinRepository medecinRepository;
    private final PrescriptionMapper prescriptionMapper;
    private final PrescriptionRepository prescriptionRepository;
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;
    private final RendezVousMapper rendezVousMapper;
    private final RendezVousRepository rendezVousRepository;

    @Autowired
    public ConsultationService(ConsultationRepository consultationRepository, ConsultationMapper consultationMapper,
                               TypeConsultationRepository typeConsultationRepository, TypeConsultationMapper typeConsultationMapper,
                               MedecinMapper medecinMapper, MedecinRepository medecinRepository,
                               PrescriptionMapper prescriptionMapper, PrescriptionRepository prescriptionRepository,
                               PatientMapper patientMapper, PatientRepository patientRepository, RendezVousMapper rendezVousMapper,
                               RendezVousRepository rendezVousRepository) {

        this.consultationRepository = consultationRepository;
        this.consultationMapper = consultationMapper;
        this.typeConsultationRepository = typeConsultationRepository;
        this.typeConsultationMapper = typeConsultationMapper;
        this.medecinMapper = medecinMapper;
        this.medecinRepository = medecinRepository;
        this.prescriptionMapper = prescriptionMapper;
        this.prescriptionRepository = prescriptionRepository;
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.rendezVousMapper = rendezVousMapper;
        this.rendezVousRepository = rendezVousRepository;
    }

    // Controle de champs de saisie
    public void controleDeSaisie(ConsultationDto consultationDto){
        if (
                consultationDto.getDateConsultation() == null ||
                consultationDto.getSynthese() == null ||
                consultationDto.getSynthese().isEmpty() ||
                consultationDto.getTypeConsultation() == null ||
                consultationDto.getRendezVouses() == null ||
                consultationDto.getPrescription() == null ||
                consultationDto.getRendezVouses().getPatient() == null ||
                consultationDto.getMedecin() == null
        ){
            throw new RuntimeException("Veuiller saisir tous les champs");
        }
    }

    // Liste des consultations
    public List<ConsultationDto> liste(){
        return StreamSupport.stream(consultationRepository.findAll().spliterator(), false)
                .map(consultationMapper::toConsultation)
                .collect(Collectors.toList());
    }

    // Ajouter une nouvelle consultation
    public ConsultationDto ajout(ConsultationDto consultationDto){
        /*
        * Controle de saisie
        * */
        controleDeSaisie(consultationDto);
        try {

            TypeConsultationDto typeConsultation = consultationDto.getTypeConsultation();

            PatientDto patientDto = consultationDto.getRendezVouses().getPatient();
            PatientDto newPatientDto = patientMapper.toPatient(patientRepository.save(patientMapper.fromPatient(patientDto)));

            // On doit d'abord ajouter un Patient avant un rendez-vous
            RendezVousDto rendezVousDto = consultationDto.getRendezVouses();
            rendezVousDto.setPatient(newPatientDto);
            RendezVousDto newRendezVousDto = rendezVousMapper.toRendezVous(rendezVousRepository.save(rendezVousMapper.fromRendezVous(rendezVousDto)));

            PrescriptionDto prescriptionDto = consultationDto.getPrescription();
            MedecinDto medecinDto = consultationDto.getMedecin();
            TypeConsultationDto newTypeConsultation = typeConsultationMapper.toTypeConsultation(typeConsultationRepository.save(typeConsultationMapper.fromTypeConsultation(typeConsultation)));
            PrescriptionDto newPrescriptionDto = prescriptionMapper.toPrescription(prescriptionRepository.save(prescriptionMapper.fromPrescription(prescriptionDto)));
            MedecinDto newMedecinDto = medecinMapper.toMedecin(medecinRepository.save(medecinMapper.fromMedecin(medecinDto)));

            consultationDto.setTypeConsultation(newTypeConsultation);
            consultationDto.setPrescription(newPrescriptionDto);

            consultationDto.setPatient(newPatientDto);
            consultationDto.setRendezVouses(newRendezVousDto);
            consultationDto.setMedecin(newMedecinDto);
            consultationDto.getRendezVouses().setPatient(newPatientDto);


            return consultationMapper.toConsultation(consultationRepository.save(consultationMapper.fromConsultation(consultationDto)));

        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(" existe déjà !!!",e);

        }catch (DataAccessException e) {
            throw new RuntimeException("Erreur de connexion à la base de données !!!", e);

        }catch (Exception e){
            throw new RuntimeException("Une erreur s'est produite lors de cette opération !!!", e);
        }
    }

    // Get Consultation ById
    public ConsultationDto getById(Long id){
        return consultationMapper.toConsultation(consultationRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Cette consultation n'existe pas")));
    }













}
