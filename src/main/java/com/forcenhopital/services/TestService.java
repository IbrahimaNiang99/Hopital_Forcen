package com.forcenhopital.services;

import com.forcenhopital.repository.ConsultationRepository;
import com.forcenhopital.repository.HospitalisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final HospitalisationRepository hospitalisationRepository;
    private final ConsultationRepository consultationRepository;

    public TestService(HospitalisationRepository hospitalisationRepository, ConsultationRepository consultationRepository) {
        this.hospitalisationRepository = hospitalisationRepository;
        this.consultationRepository = consultationRepository;
    }



}
