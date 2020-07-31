package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.domain.PatientDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList) {
        return patientList.stream()
                .map(p -> new PatientDto(p.getId(), p.getName(), p.getLastname(), p.getPesel()))
                .collect(Collectors.toList());
    }
}
