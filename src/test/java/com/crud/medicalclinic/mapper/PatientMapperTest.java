package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.domain.PatientDto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PatientMapperTest {
    private PatientMapper patientMapper;

    @Before
    public void beforeTest() {
        patientMapper = new PatientMapper();
    }

    @Test
    public void mapToPatientTest() {
        // Given
        PatientDto patientDto = new PatientDto(1L, "name", "lastname", 123456789);
        // When
        Patient result = patientMapper.mapToPatient(patientDto);
        // Then
        assertEquals(1L, result.getId());
        assertEquals("name", result.getName());
        assertEquals("lastname", result.getLastname());
        assertEquals(123456789, result.getPesel());
    }

    @Test
    public void mapToPatientDtoTest() {
        // Given
        Patient patient = new Patient(1L, "name", "lastname", 123456789);
        // When
        PatientDto result = patientMapper.mapToPatientDto(patient);
        // Then
        assertEquals(1L, result.getId());
        assertEquals("name", result.getName());
        assertEquals("lastname", result.getLastname());
        assertEquals(123456789, result.getPesel());
    }

    @Test
    public void mapToPatientDtoListTest() {
        // Given
        List<Patient> patientList = new ArrayList<>();
        // When
        List<PatientDto> result = patientMapper.mapToPatientDtoList(patientList);
        // Then
        assertEquals(0, result.size());
    }
}
