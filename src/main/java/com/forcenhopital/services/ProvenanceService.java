package com.forcenhopital.services;

import com.forcenhopital.dto.ProvenanceDto;
import com.forcenhopital.entities.Provenance;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.exceptions.RequestException;
import com.forcenhopital.mapping.ProvenanceMapper;
import com.forcenhopital.repository.ProvenanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ProvenanceService {
    private final ProvenanceRepository provenanceRepository;
    private final ProvenanceMapper provenanceMapper;
    MessageSource messageSource;

    @Autowired
    public ProvenanceService(ProvenanceRepository provenanceRepository, ProvenanceMapper provenanceMapper, MessageSource messageSource) {
        this.provenanceRepository = provenanceRepository;
        this.provenanceMapper = provenanceMapper;
        this.messageSource = messageSource;
    }

    // Controle de saisie
    public void controleDeSaisie(ProvenanceDto provenanceDto){
        if (
                provenanceDto.getLieuDeProvenance() == null || provenanceDto.getLieuDeProvenance().isEmpty()
        ){
            throw new RuntimeException("Veuillez donner le lieu de provenance");
        }
    }

    // Ajouter une provenance
    public ProvenanceDto ajouter(ProvenanceDto provenanceDto){
        controleDeSaisie(provenanceDto);
        try {
            return provenanceMapper.toProvenance(provenanceRepository.save(provenanceMapper.fromProvenance(provenanceDto)));
        }catch (Exception e){
            throw new RuntimeException("Une erreur s'est produite lors de cette opération", e);
        }
    }

    // Recuperer une provenance
    public ProvenanceDto getProvenanceById(Long id){
        return provenanceMapper.toProvenance(provenanceRepository.findById(id)
                .orElseThrow( ()->
                        new EntityNotFoundException("Il n'existe pas de provenance d'id = "+id)));
    }

    // Liste de provenance
    public List<ProvenanceDto> listeProvenance(){

        return StreamSupport.stream(provenanceRepository.findAll().spliterator(), false)
                .map(provenanceMapper::toProvenance)
                .collect(Collectors.toList());
    }

    // Supprimer une provenance
    public void deleteProvenance(Long id){
        try {
            provenanceRepository.deleteById(id);
        }catch (Exception e){
            //throw new RequestException("Erreur de suppression", HttpStatus.CONFLICT);
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
        /*
    * (messageSource.getMessage("role.errordeletion", new Object[]{id}, Locale.getDefault()),
                    HttpStatus.CONFLICT);*/

}
