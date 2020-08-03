package com.crud.medicalclinic.service;

import com.crud.medicalclinic.domain.Appointment;
import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService appointmentService;
    @Mock
    private AppointmentRepository appointmentRepository;
    @Mock
    private Office office;
    @Mock
    private Doctor doctor;
    @Mock
    private Patient patient;

    @Test
    public void getAllTest() {
        // Given
        List<Appointment> appointmentList = new ArrayList<>();
        // When
        when(appointmentRepository.findAll()).thenReturn(appointmentList);
        List<Appointment> result = appointmentService.getAll();
        // Then
        assertEquals(0, result.size());
    }

    @Test
    public void getTest() {
        // Given
        Appointment appointment = new Appointment(1L, office, patient, doctor,
                LocalDate.of(2020,07,28), "status", new ArrayList<>());
        // When
        when(appointmentRepository.findById(1L)).thenReturn(java.util.Optional.of(appointment));
        Optional<Appointment> result = appointmentService.get(appointment.getId());
        // Then
        assertEquals("status", result.get().getStatus());
    }

    @Test
    public void saveTest() {
        // Given
        Appointment appointment = new Appointment(1L, office, patient, doctor,
                LocalDate.of(2020,07,28), "status", new ArrayList<>());
        // When
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        Appointment result = appointmentService.save(appointment);
        // Then
        assertEquals("status", result.getStatus());
    }

    @Test
    public void deleteTest() {
        // Given
        Appointment appointment = new Appointment(1L, office, patient, doctor,
                LocalDate.of(2020,07,28), "status", new ArrayList<>());
        // When
        appointmentService.deleteById(appointment.getId());
        // Then
        verify(appointmentRepository, times(1)).deleteById(appointment.getId());
    }
}
