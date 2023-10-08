package com.forcenhopital.services;

import com.forcenhopital.dto.PrescriptionDto;
import com.forcenhopital.mapping.PrescriptionMapper;
import com.forcenhopital.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;

    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                               PrescriptionMapper prescriptionMapper) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionMapper = prescriptionMapper;
    }

    public PrescriptionDto ajout(PrescriptionDto prescriptionDto){
        return prescriptionMapper.toPrescription(prescriptionRepository.save(prescriptionMapper.fromPrescription(prescriptionDto)));
    }
}
