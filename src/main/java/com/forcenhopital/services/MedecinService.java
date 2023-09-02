package com.forcenhopital.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.forcenhopital.entities.Specialite;
import com.forcenhopital.exceptions.EntityNotFoundException;
import com.forcenhopital.repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.forcenhopital.dto.MedecinDto;
import com.forcenhopital.entities.Medecin;
import com.forcenhopital.entities.ServiceEntity;
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
    private final ServiceRepository serviceRepository;
    private final SpecialiteRepository specialiteRepository;
    MessageSource messageSource;

    @Autowired
    public MedecinService(MedecinRepository medecinRepository, MedecinMapper medecinMapper, MessageSource messageSource, ServiceRepository serviceRepository, SpecialiteRepository specialiteRepository) {

        this.medecinRepository = medecinRepository;
        this.medecinMapper = medecinMapper;
        this.messageSource = messageSource;
        this.serviceRepository = serviceRepository;
        this.specialiteRepository = specialiteRepository;
    }

    // Récuperer la liste des medecins
    public List<MedecinDto> listeMedecin(){

        List<Medecin> medecins = medecinRepository.findAll();
        if (medecins == null || medecins.isEmpty()
        ) {
             throw new RuntimeException("La liste de medecins renvoyé est vide");
        }
            return medecins.stream()
                .map(medecinMapper::toMedecin)
                .collect(Collectors.toList());
    }

    // Verifier l'adresse email
    public void isValidEmail(MedecinDto medecinDto){
        if (!Helper.isValidEmail(medecinDto.getEmail())) {
            throw new RuntimeException("L'adresse email que vous avez fourni n'est pas valide");
        }
    }

    // Verifier le numéro de telephone
    public void isValidSenegalPhoneNumber(MedecinDto medecinDto){

        if (!Helper.isValidSenegalPhoneNumber(medecinDto.getTelPersonnel())) {
            throw new RuntimeException("Le numéro de téléphone n'est pas celui du Sénégal");

        }else if(!Helper.isValidSenegalPhoneNumber(medecinDto.getTelTravail())){
            throw new RuntimeException("Le numéro de téléphone n'est pas celui du Sénégal");
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
            throw new RuntimeException("Veuillez renseigner tous les champs !!!");
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
            //
            throw new RuntimeException("L'email ou le numéro de téléphone existe déjà !!!", e);

        }catch (DataAccessException e){
            throw new RuntimeException("Erreur de connexion a la base de donnees ", e);

        }catch (Exception e){
            throw new RuntimeException("Une erreur s'est produite lors de cette opération", e);
        }
    }

    // Recuperer un medecin grace à son id
    public Medecin getMedecinById(Long id){
            return medecinRepository.findById(id).
                    orElseThrow(()->
                            new EntityNotFoundException(("Il n'existe de pas de medecin avec un id = "+id)));
    }    

    // Attribuer un sercice à un medecin
    public Medecin addServiceToMedecin(Long idMedecin, Long idService){
        Set<ServiceEntity> serviceSet = null;

        Medecin medecin = medecinRepository.findById(idMedecin)
                .orElseThrow(()->
                        new EntityNotFoundException(("Il n'existe de pas de medecin avec un id = "+idMedecin)));

        ServiceEntity serviceEntity = serviceRepository.findById(idService)
                .orElseThrow(()->
                        new EntityNotFoundException(("Il n'existe de pas de service avec un id = "+idService)));

        serviceSet = medecin.getServices();
        serviceSet.add(serviceEntity);
        medecin.setServices(serviceSet);
        return medecinRepository.save(medecin);
    }

    // Attribuer un sercice à un medecin
    public Medecin addSpecialiteToMedecin(Long idMedecin, Long idSpecialite){
        Set<Specialite> specialiteSet = null;
        Medecin medecin = medecinRepository.findById(idMedecin)
                .orElseThrow(()->
                        new EntityNotFoundException(("Il n'existe de pas de medecin avec un id = "+idMedecin)));

        Specialite specialite = specialiteRepository.findById(idSpecialite)
                .orElseThrow(()->
                        new EntityNotFoundException(("Il n'existe de pas de specialiste avec un id = "+idSpecialite)));

        specialiteSet = medecin.getSpecialites();
        specialiteSet.add(specialite);
        medecin.setSpecialites(specialiteSet);
        return medecinRepository.save(medecin);
    }

}
