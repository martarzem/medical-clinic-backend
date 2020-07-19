package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.domain.PatientDto;
import org.springframework.stereotype.Component;


@Component
public class PatientMapper {
    public Patient mapToPatient(final PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getLastname(),
                patientDto.getPesel()
        );
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getLastname(),
                patient.getPesel()
        );
    }
}
