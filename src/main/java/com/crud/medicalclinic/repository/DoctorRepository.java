package com.crud.medicalclinic.repository;

import com.crud.medicalclinic.domain.Doctor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DoctorRepository extends MedicalClinicRepository<Doctor> {
    List<Doctor> findByLastname(String lastname);
}
