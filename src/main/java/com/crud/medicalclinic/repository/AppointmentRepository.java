package com.crud.medicalclinic.repository;

import com.crud.medicalclinic.domain.Appointment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AppointmentRepository extends MedicalClinicRepository<Appointment> {
}
