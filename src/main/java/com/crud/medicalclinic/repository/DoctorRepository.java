package com.crud.medicalclinic.repository;

import com.crud.medicalclinic.domain.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MedicalClinicRepository<Doctor> {
}
