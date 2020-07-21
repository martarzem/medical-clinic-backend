package com.crud.medicalclinic.repository;

import com.crud.medicalclinic.domain.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MedicalClinicRepository<Patient> {
}
