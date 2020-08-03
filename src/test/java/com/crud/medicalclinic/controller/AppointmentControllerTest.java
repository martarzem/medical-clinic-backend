package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.*;
import com.crud.medicalclinic.mapper.AppointmentMapper;
import com.crud.medicalclinic.service.AppointmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AppointmentMapper appointmentMapper;
    @MockBean
    private AppointmentService appointmentService;
    @MockBean
    private Doctor doctor;
    @MockBean
    private Patient patient;
    @MockBean
    private Office office;

    @Test
    public void getAllTest() throws Exception {
        // Given
        List<AppointmentDto> appointmentDtos = new ArrayList<>();

        when(appointmentMapper.mapToAppointmentDtoList(appointmentService.getAll())).thenReturn(appointmentDtos);
        // When & Then
        mockMvc.perform(get("/medical_clinic/appointment")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void deleteTest() throws Exception {
        // Given
        Appointment appointment = new Appointment(1L, office, patient, doctor,
                LocalDate.of(2020,7,28), "status", new ArrayList<>());

        when(appointmentService.get(appointment.getId())).thenReturn(Optional.of(appointment));
        // When & Then
        mockMvc.perform(delete("/medical_clinic/appointment/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(appointmentService).deleteById(appointment.getId());
    }
}
