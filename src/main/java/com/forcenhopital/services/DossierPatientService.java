package com.forcenhopital.services;

import com.forcenhopital.dto.ConsultationDto;
import com.forcenhopital.dto.HospitalisationDto;
import com.forcenhopital.payload.DossierPatientLoad;
import com.forcenhopital.mapping.ConsultationMapper;
import com.forcenhopital.mapping.HospitalisationMapper;
import com.forcenhopital.repository.ConsultationRepository;
import com.forcenhopital.repository.HospitalisationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DossierPatientService {
    private final HospitalisationRepository hospitalisationRepository;
    private final ConsultationRepository consultationRepository;
    private final HospitalisationMapper hospitalisationMapper;
    private final ConsultationMapper consultationMapper;


    public DossierPatientService(HospitalisationRepository hospitalisationRepository,
                                 ConsultationRepository consultationRepository,
                                 HospitalisationMapper hospitalisationMapper,
                                 ConsultationMapper consultationMapper){
        this.hospitalisationRepository = hospitalisationRepository;
        this.consultationRepository = consultationRepository;
        this.hospitalisationMapper = hospitalisationMapper;
        this.consultationMapper = consultationMapper;
    }

    public DossierPatientLoad liste(Long id){
        DossierPatientLoad result = new DossierPatientLoad();
        List<ConsultationDto> listConsDossier = new ArrayList<>();

        List<ConsultationDto> listeConsultationDtos = StreamSupport.stream(consultationRepository.findAll().spliterator(), false)
                .map(consultationMapper::toConsultation)
                .collect(Collectors.toList());

        for (ConsultationDto consultation : listeConsultationDtos){
            if (consultation.getPatient().getIdPatient() == id){
                listConsDossier.add(consultation);
            }
        }

        List<HospitalisationDto> listHospiDossier = new ArrayList<>();

        List<HospitalisationDto> listeHospitalisations = StreamSupport.stream(hospitalisationRepository.findAll().spliterator(), false)
                .map(hospitalisationMapper::toHospitalisation)
                .collect(Collectors.toList());

        for (HospitalisationDto hospitalisation : listeHospitalisations){
            if (hospitalisation.getPatient().getIdPatient() == id){
                listHospiDossier.add(hospitalisation);
            }
        }

        result.setListCons(listConsDossier);
        result.setListHospi(listHospiDossier);
        return result;

    }


}
