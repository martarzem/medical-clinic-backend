package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppointmentMapperTest {
    private AppointmentMapper appointmentMapper;
    private Office office;
    private Patient patient;
    private Doctor doctor;

    @Before
    public void beforeTest() {
        appointmentMapper = new AppointmentMapper();
        office = new Office(1L, 1, "description");
        patient = new Patient(1L, "name", "lastname", 123456789);
        doctor = new Doctor(1L, "name", "lastname", "specialisation", "review");
    }

    @Test
    public void mapToAppointmentTest() {
        // Given
        AppointmentDto.AppointmentDtoBuilder appointmentDto = new AppointmentDto.AppointmentDtoBuilder()
            .setId(1L)
            .setOffice(office)
            .setPatient(patient)
            .setDoctor(doctor)
            .setDate(LocalDate.of(2020,07,28))
            .setStatus("status")
            .setPurposes("headache").setPurposes("flu");

        // When
        Appointment result = appointmentMapper.mapToAppointment(appointmentDto);
        // Then
        assertEquals(1L, result.getId());
        assertEquals(1, result.getOffice().getNumber());
        assertEquals("lastname", result.getPatient().getLastname());
        assertEquals("specialisation", result.getDoctor().getSpecialisation());
        assertEquals(LocalDate.of(2020,07,28), result.getDate());
        assertEquals("status", result.getStatus());
        assertEquals(2, result.getPurposes().size());
    }

    @Test
    public void mapToAppointmentDtoTest() {
        // Given
        Appointment appointment = new Appointment(1L, office, patient, doctor,
                LocalDate.of(2020,07,28), "status", new ArrayList<>());
        // When
        AppointmentDto result = appointmentMapper.mapToAppointmentDto(appointment);
        // Then
        assertEquals(1L, result.getId());
        assertEquals(1, result.getOffice().getNumber());
        assertEquals("lastname", result.getPatient().getLastname());
        assertEquals("specialisation", result.getDoctor().getSpecialisation());
        //assertEquals(LocalDate.of(2020,07,28), result.getDate());
        assertEquals("status", result.getStatus());
        //assertEquals(0, result.getPurposes().size());
    }

    @Test
    public void mapToAppointmentDtoListTest() {
        // Given
        List<Appointment> appointmentList = new ArrayList<>();
        // When
        List<AppointmentDto> result = appointmentMapper.mapToAppointmentDtoList(appointmentList);
        // Then
        assertEquals(0, result.size());
    }
}
