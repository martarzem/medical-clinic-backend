package com.crud.medicalclinic.service;

import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;
    @Mock
    private PatientRepository patientRepository;

    @Test
    public void getAllTest() {
        // Given
        List<Patient> patientList = new ArrayList<>();
        // When
        when(patientRepository.findAll()).thenReturn(patientList);
        List<Patient> result = patientService.getAll();
        // Then
        assertEquals(0, result.size());
    }

    @Test
    public void getTest() {
        // Given
        Patient patient = new Patient(1L, "name", "lastname", 123456789);
        // When
        when(patientRepository.findById(1L)).thenReturn(java.util.Optional.of(patient));
        Optional<Patient> result = patientService.get(patient.getId());
        // Then
        assertEquals("name", result.get().getName());
    }

    @Test
    public void saveTest() {
        // Given
        Patient patient = new Patient(1L, "name", "lastname", 123456789);
        // When
        when(patientRepository.save(patient)).thenReturn(patient);
        Patient result = patientService.save(patient);
        // Then
        assertEquals("name", result.getName());
    }

    @Test
    public void deleteTest() {
        // Given
        Patient patient = new Patient(1L, "name", "lastname", 123456789);

        // When
        patientService.deleteById(patient.getId());
        // Then
        verify(patientRepository, times(1)).deleteById(patient.getId());
    }
}
