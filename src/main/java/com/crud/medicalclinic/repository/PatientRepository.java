package com.crud.medicalclinic.repository;

import com.crud.medicalclinic.domain.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PatientRepository extends MedicalClinicRepository<Patient> {
}
