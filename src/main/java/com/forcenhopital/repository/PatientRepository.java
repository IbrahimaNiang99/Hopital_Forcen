package com.forcenhopital.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forcenhopital.entities.Patient;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

   /* @Query("SELECT h, c FROM Hospitalisation AS h INNER JOIN Consultation AS c ON h.patient.idPatient = c.patient.idPatient AND h.patient.idPatient = ?1")
    @JsonIgnore
    */
    @Query("select h from Hospitalisation AS h where h.patient.idPatient = 1L")
    List<Object[]> liste(Long id);

    //SELECT hospitalisation.*, consultation.* FROM hospitalisation INNER JOIN consultation ON hospitalisation.patient_id = consultation.patient_id;


}
