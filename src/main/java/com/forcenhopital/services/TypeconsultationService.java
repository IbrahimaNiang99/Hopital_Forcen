package com.forcenhopital.services;

import com.forcenhopital.dto.TypeConsultationDto;
import com.forcenhopital.mapping.TypeConsultationMapper;
import com.forcenhopital.repository.TypeConsultationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TypeconsultationService {
    private final TypeConsultationRepository typeConsultationRepository;
    private final TypeConsultationMapper typeConsultationMapper;

    public TypeconsultationService(TypeConsultationRepository typeConsultationRepository, TypeConsultationMapper typeConsultationMapper) {
        this.typeConsultationRepository = typeConsultationRepository;
        this.typeConsultationMapper = typeConsultationMapper;
    }

    public List<TypeConsultationDto> liste(){
        return StreamSupport.stream(typeConsultationRepository.findAll().spliterator(), false)
                .map(typeConsultationMapper::toTypeConsultation)
                .collect(Collectors.toList());
    }
}
