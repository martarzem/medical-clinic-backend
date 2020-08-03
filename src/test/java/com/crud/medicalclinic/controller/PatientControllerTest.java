package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.domain.OfficeDto;
import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.domain.PatientDto;
import com.crud.medicalclinic.mapper.OfficeMapper;
import com.crud.medicalclinic.mapper.PatientMapper;
import com.crud.medicalclinic.service.OfficeService;
import com.crud.medicalclinic.service.PatientService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PatientController.class)
public class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PatientMapper patientMapper;
    @MockBean
    private PatientService patientService;

    @Test
    public void getAllTest() throws Exception {
        // Given
        List<PatientDto> patientDtos = new ArrayList<>();

        when(patientMapper.mapToPatientDtoList(patientService.getAll())).thenReturn(patientDtos);
        // When & Then
        mockMvc.perform(get("/medical_clinic/patient")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getTest() throws Exception {
        // Given
        Patient patient = new Patient(1L, "name", "lastname", 123456789);

        PatientDto patientDto = new PatientDto(1L, "name", "lastname", 123456789);

        when(patientService.get(patient.getId())).thenReturn(Optional.of(patient));
        when(patientMapper.mapToPatientDto(patient)).thenReturn(patientDto);
        // When & Then
        mockMvc.perform(get("/medical_clinic/patient/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastname", is("lastname")));
    }

    @Test
    public void createTest() throws Exception {
        // Given
        Patient patient = new Patient(1L, "name", "lastname", 123456789);

        PatientDto patientDto = new PatientDto(1L, "name", "lastname", 123456789);

        when(patientMapper.mapToPatient(any())).thenReturn(patient);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(patientDto);
        // When & Then
        mockMvc.perform(post("/medical_clinic/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

        verify(patientService).save(patient);
    }

    @Test
    public void updateTest() throws Exception {
        // Given
        PatientDto patientDto = new PatientDto(1L, "name", "lastname", 123456789);

        when(patientMapper.mapToPatientDto(patientService.save(patientMapper.mapToPatient(patientDto))))
                .thenReturn(patientDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(patientDto);
        // When & Then
        mockMvc.perform(put("/medical_clinic/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastname", is("lastname")));
    }

    @Test
    public void deleteTest() throws Exception {
        // Given
        Patient patient = new Patient(1L, "name", "lastname", 123456789);

        when(patientService.get(patient.getId())).thenReturn(Optional.of(patient));
        // When & Then
        mockMvc.perform(delete("/medical_clinic/patient/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(patientService).deleteById(patient.getId());
    }
}
