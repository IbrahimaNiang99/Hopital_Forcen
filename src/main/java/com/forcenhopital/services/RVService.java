package com.forcenhopital.services;

import com.forcenhopital.dto.PatientDto;
import com.forcenhopital.dto.RendezVousDto;
import com.forcenhopital.entities.Patient;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.exceptions.RequestException;
import com.forcenhopital.mapping.PatientMapper;
import com.forcenhopital.mapping.RendezVousMapper;
import com.forcenhopital.repository.PatientRepository;
import com.forcenhopital.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class RVService {
    private final RendezVousRepository rendezVousRepository;
    private final RendezVousMapper rendezVousMapper;
    private final PatientMapper patientMapper;
    private  final PatientRepository patientRepository;

    @Autowired
    public RVService(RendezVousRepository rendezVousRepository, RendezVousMapper rendezVousMapper, PatientMapper patientMapper, PatientRepository patientRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.rendezVousMapper = rendezVousMapper;
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    // Controle de champs de saisie
    public void controleDeSaisie(RendezVousDto rendezVousDto){
        if (
                rendezVousDto.getMedecin() == null || rendezVousDto.getMedecin().isEmpty() ||
                rendezVousDto.getService() == null || rendezVousDto.getService().isEmpty() ||
                rendezVousDto.getDateRDV() == null
        ){
            throw new RuntimeException("Veuiller saisir tous les champs ");
        }
    }

    // Liste des Rendez vous
    public List<RendezVousDto> liste(){
        return StreamSupport.stream(rendezVousRepository.findAll().spliterator(), false)
                .map(rendezVousMapper::toRendezVous)
                .collect(Collectors.toList());
    }

    // Ajouter Rendez vous
    public RendezVousDto ajout(RendezVousDto rendezVousDto) {

       /* try {
            PatientDto patientDto = rendezVousDto.getPatient();
            PatientDto savePatient = patientMapper.toPatient(patientRepository.save(patientMapper.fromPatient(patientDto)));
            rendezVousDto.setPatient(savePatient);
            return rendezVousMapper.toRendezVous(rendezVousRepository.save(rendezVousMapper.fromRendezVous(rendezVousDto)));

        } catch (DataAccessException e) {
            throw new RequestException("Tous les champs sont obligatoire ", HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            throw new RuntimeException("Une erreur s'est produite lors de cette opération", e);
        }*/
        return  rendezVousDto;
    }

    // Get rv by id
    public RendezVousDto getRvById(Long idRV){
        return rendezVousMapper.toRendezVous(rendezVousRepository.findById(idRV)
                .orElseThrow( () -> new EntityNotFoundException("Ce render-vous n'existe pas")));
    }

}
