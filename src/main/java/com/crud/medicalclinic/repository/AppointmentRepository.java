package com.crud.medicalclinic.repository;

import com.crud.medicalclinic.domain.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MedicalClinicRepository<Appointment> {
}
