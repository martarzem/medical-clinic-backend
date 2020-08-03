package com.crud.medicalclinic.service;

import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.repository.DoctorRepository;
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
public class DoctorServiceTest {

    @InjectMocks
    private DoctorService doctorService;
    @Mock
    private DoctorRepository doctorRepository;

    @Test
    public void getAllTest() {
        // Given
        List<Doctor> doctorList = new ArrayList<>();
        // When
        when(doctorRepository.findAll()).thenReturn(doctorList);
        List<Doctor> result = doctorService.getAll();
        // Then
        assertEquals(0, result.size());
    }

    @Test
    public void getTest() {
        // Given
        Doctor doctor = new Doctor(1L, "name", "lastname",
                "specialisation", "review");
        // When
        when(doctorRepository.findById(1L)).thenReturn(java.util.Optional.of(doctor));
        Optional<Doctor> result = doctorService.get(doctor.getId());
        // Then
        assertEquals("name", result.get().getName());
    }

    @Test
    public void saveTest() {
        // Given
        Doctor doctor = new Doctor(1L, "name", "lastname",
                "specialisation", "review");
        // When
        when(doctorRepository.save(doctor)).thenReturn(doctor);
        Doctor result = doctorService.save(doctor);
        // Then
        assertEquals("name", result.getName());
    }

    @Test
    public void deleteTest() {
        // Given
        Doctor doctor = new Doctor(1L, "name", "lastname",
                "specialisation", "review");
        // When
        doctorService.deleteById(doctor.getId());
        // Then
        verify(doctorRepository, times(1)).deleteById(doctor.getId());
    }
}
