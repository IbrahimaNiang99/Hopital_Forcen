package com.forcenhopital.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.forcenhopital.dto.SpecialiteDto;
import com.forcenhopital.entities.Specialite;
import com.forcenhopital.mapping.SpecialiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.forcenhopital.repository.SpecialiteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SpecialiteService {
    private final SpecialiteRepository specialiteRepository;
    private final SpecialiteMapper specialiteMapper;

    @Autowired
    public SpecialiteService(SpecialiteRepository specialiteRepository, SpecialiteMapper specialiteMapper){
        this.specialiteRepository = specialiteRepository;
        this.specialiteMapper = specialiteMapper;
    }

    // Vérification des saisies
    public void controleDeChampDeSaisie(SpecialiteDto specialiteDto){
        if (specialiteDto.getNomSpecialite() == null || specialiteDto.getNomSpecialite().isEmpty()) {
             throw new RuntimeException("Veuiller saisir le nom de la spécialité");
        }
    }

    // Lister les spécialités
    public List<SpecialiteDto> listeSpecialite(){

        return StreamSupport.stream(specialiteRepository.findAll().spliterator(), false)
                            .map(specialiteMapper::toSpecialite)
                            .collect(Collectors.toList());
    }

    // Ajouter une specialite
    public SpecialiteDto ajoutSpecialite(SpecialiteDto specialiteDto){
        controleDeChampDeSaisie(specialiteDto);
        try {
            return specialiteMapper.toSpecialite(
                specialiteRepository.save(specialiteMapper.fromSpecialite(specialiteDto))
            );


        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Le nom de la existe déjà !!!", e);

        }catch (DataAccessException e){
            throw new RuntimeException("Erreur de connexion a la base de donnees ", e);

        }catch (Exception e){
            throw new RuntimeException("Une erreur s'est produite lors de cette opération", e);
        }
    }
}
