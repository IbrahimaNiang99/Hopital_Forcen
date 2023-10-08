package com.forcenhopital.services;

import com.forcenhopital.dto.*;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.mapping.*;
import com.forcenhopital.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    private final ChambreMapper chambreMapper;
    private final ChambreRepository chambreRepository;
    private final TraitementMapper traitementMapper;
    private final TraitementRepository traitementRepository;

    @Autowired
    public HospitalisationService(HospitalisationRepository hospitalisationRepository, HospitalisationMapper hospitalisationMapper,
                                  FactureMapper factureMapper, PatientMapper patientMapper, PatientRepository patientRepository,
                                  FactureRepository factureRepository, ChambreMapper chambreMapper, ChambreRepository chambreRepository, TraitementMapper traitementMapper, TraitementRepository traitementRepository) {
        this.hospitalisationRepository = hospitalisationRepository;
        this.hospitalisationMapper = hospitalisationMapper;
        this.factureMapper = factureMapper;
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.factureRepository = factureRepository;
        this.chambreMapper = chambreMapper;
        this.chambreRepository = chambreRepository;
        this.traitementMapper = traitementMapper;
        this.traitementRepository = traitementRepository;
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
/*
    // Nouvelle hospitalisation
    public HospitalisationDto ajout(HospitalisationDto hospitalisationDto, Long idPatient, Long idChambre){
        //controleDeChamps(hospitalisationDto);

        try {
            List<TraitementDto> traitements = null;
            FactureDto facture = hospitalisationDto.getFacture();
            FactureDto newFacture = factureMapper.toFacture(factureRepository.save(factureMapper.fromFacture(facture)));


            PatientDto patient = patientMapper.toPatient(patientRepository.findById(idPatient)
                    .orElseThrow( () -> new EntityNotFoundException("Ce patient n'existe pas")));

            ChambreDto chambre = chambreMapper.toChambre(chambreRepository.findById(idChambre)
                    .orElseThrow( () -> new EntityNotFoundException("Cette chambre n'existe pas")));

            TraitementDto traitement = new TraitementDto();

            TraitementDto newTraitement = traitementMapper.toTraitement(traitementRepository.save(traitementMapper.fromTraitement(traitement)));

            traitements = hospitalisationDto.getTraitements();

            if (traitements == null){
                traitements = new ArrayList<>();
            }
            traitements.add(newTraitement);
            hospitalisationDto.setTraitements(traitements);
            hospitalisationDto.setFacture(newFacture);
            hospitalisationDto.setPatient(patient);
            hospitalisationDto.setChambre(chambre);

            return hospitalisationMapper.toHospitalisation(hospitalisationRepository
                    .save(hospitalisationMapper
                            .fromHospitalisation(hospitalisationDto)));

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
*/

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
    public HospitalisationDto update(Long idHospi, HospitalisationDto hospitalisationDto){
        //controleDeChamps(hospitalisationDto);

        try {

            if (hospitalisationDto.getTraitements() != null){
                hospitalisationDto.setTraitements(hospitalisationDto.getTraitements());
            }

            return hospitalisationRepository.findById(idHospi)
                    .map(entity ->{
                        hospitalisationDto.setIdAdmission(idHospi);
                        return hospitalisationMapper.toHospitalisation(
                                hospitalisationRepository.save(hospitalisationMapper.fromHospitalisation(hospitalisationDto)));
                    }).orElseThrow( ()-> new EntityNotFoundException("Cette hospitalisation n'existe pas"));

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
