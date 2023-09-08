package com.forcenhopital.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.forcenhopital.dto.ServiceDto;
import com.forcenhopital.dto.SpecialiteDto;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.exceptions.RequestException;
import com.forcenhopital.mapping.ServiceMapper;
import com.forcenhopital.mapping.SpecialiteMapper;
import com.forcenhopital.repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.forcenhopital.dto.MedecinDto;
import com.forcenhopital.entities.Medecin;
import com.forcenhopital.helper.Helper;
import com.forcenhopital.mapping.MedecinMapper;
import com.forcenhopital.repository.MedecinRepository;
import com.forcenhopital.repository.ServiceRepository;

import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class MedecinService {
    private final MedecinRepository medecinRepository;
    private final MedecinMapper medecinMapper;
    private final ServiceMapper serviceMapper;
    private final ServiceRepository serviceRepository;
    private final SpecialiteRepository specialiteRepository;
    private final SpecialiteMapper specialiteMapper;
    MessageSource messageSource;
    @Autowired
    public MedecinService(MedecinRepository medecinRepository, MedecinMapper medecinMapper, MessageSource messageSource, ServiceRepository serviceRepository, SpecialiteRepository specialiteRepository, ServiceMapper serviceMapper, SpecialiteMapper specialiteMapper) {
        this.medecinRepository = medecinRepository;
        this.medecinMapper = medecinMapper;
        this.messageSource = messageSource;
        this.serviceRepository = serviceRepository;
        this.specialiteRepository = specialiteRepository;
        this.serviceMapper = serviceMapper;
        this.specialiteMapper = specialiteMapper;
    }

    // Récuperer la liste des medecins
    public List<MedecinDto> listeMedecin(){
        return StreamSupport.stream(medecinRepository.findAll().spliterator(), false)
                .map(medecinMapper::toMedecin)
                .collect(Collectors.toList());
    }

    // Verifier l'adresse email
    public void isValidEmail(MedecinDto medecinDto){
        if (!Helper.isValidEmail(medecinDto.getEmail())) {
            throw new RequestException("L'adresse email que vous avez fourni n'est pas valide");
        }
    }

    // Verifier le numéro de telephone
    public void isValidSenegalPhoneNumber(MedecinDto medecinDto){

        if (!Helper.isValidSenegalPhoneNumber(medecinDto.getTelPersonnel())) {
            throw new RequestException("Le numéro de téléphone n'est pas celui du Sénégal");

        }else if(!Helper.isValidSenegalPhoneNumber(medecinDto.getTelTravail())){
            throw new RequestException("Le numéro de téléphone n'est pas celui du Sénégal");
        }
    }

    // controle de champs de saisie
    public void controlDeSaisie(MedecinDto medecinDto){
        if (
            medecinDto.getPrenom() == null || medecinDto.getPrenom().isEmpty() ||
            medecinDto.getNom() == null || medecinDto.getNom().isEmpty() ||
            medecinDto.getDateDeNaissance() == null ||
            medecinDto.getNationalite() == null || medecinDto.getNationalite().isEmpty() ||
            medecinDto.getSexe() == null || medecinDto.getSexe().isEmpty() ||
            medecinDto.getLieuDeNaissance() == null || medecinDto.getLieuDeNaissance().isEmpty() 
            //|| medecinDto.getSpeci
        ) {
            throw new RequestException("Veuillez renseigner tous les champs !!!");
        }
    }

    // Ajouter un medecin
    public MedecinDto ajoutMedecin(MedecinDto medecinDto){

        // Vérification de l'adresse email
        isValidEmail(medecinDto);

        // vérification des numéros de téléphone
        isValidSenegalPhoneNumber(medecinDto);

        // Vérification des champs de saisie
        controlDeSaisie(medecinDto);

        try {
            return medecinMapper.toMedecin(medecinRepository.save(medecinMapper.fromMedecin(medecinDto)));

        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("L'email ou le numéro de téléphone existe déjà !!!");

        }catch (DataAccessException e){
            throw new RequestException("Erreur de connexion a la base de donnees ", HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            throw new RuntimeException("Une erreur s'est produite lors de cette opération", e);
        }
        //*/
    }

    // Recuperer un medecin grace à son id
    public MedecinDto getMedecinById(Long id){
        return medecinMapper.toMedecin(medecinRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Il n'existe pas de medecin avec un id = "+id)));
    }    

    // Attribuer un sercice à un medecin
    public MedecinDto addServiceToMedecin(Long idMedecin, Long idService){
        List<ServiceDto> serviceList = null;

        MedecinDto medecin = medecinMapper.toMedecin(medecinRepository.findById(idMedecin)
                .orElseThrow( () -> new EntityNotFoundException("Il n'existe de pas de medecin avec un id = "+idMedecin)));

        ServiceDto serviceDto = serviceMapper.toService(serviceRepository.findById(idService)
                .orElseThrow( () -> new EntityNotFoundException("Il n'existe de pas de service avec un id = "+idService)))  ;

        serviceList = medecin.getServices();
        serviceList.add(serviceDto);
        medecin.setServices(serviceList);
        return medecinMapper.toMedecin(medecinRepository.save(medecinMapper.fromMedecin(medecin)));

    }

    // Attribuer un sercice à un medecin
    public MedecinDto addSpecialiteToMedecin(Long idMedecin, Long idSpecialite){
        List<SpecialiteDto> specialiteList = null;
        MedecinDto medecin = medecinMapper.toMedecin(medecinRepository.findById(idMedecin)
                .orElseThrow(()->
                        new EntityNotFoundException(("Il n'existe de pas de medecin avec un id = "+idMedecin))));

        SpecialiteDto specialite = specialiteMapper.toSpecialite(specialiteRepository.findById(idSpecialite)
                .orElseThrow(()->
                        new EntityNotFoundException(("Il n'existe de pas de specialiste avec un id = "+idSpecialite))));

        specialiteList = medecin.getSpecialites();
        specialiteList.add(specialite);
        medecin.setSpecialites(specialiteList);
        return medecinMapper.toMedecin(medecinRepository.save(medecinMapper.fromMedecin(medecin)));
    }

}
