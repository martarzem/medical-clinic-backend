package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.domain.DoctorDto;
import com.crud.medicalclinic.mapper.DoctorMapper;
import com.crud.medicalclinic.service.DoctorService;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DoctorMapper doctorMapper;
    @MockBean
    private DoctorService doctorService;

    @Test
    public void getAllTest() throws Exception {
        // Given
        List<DoctorDto> doctorDtos = new ArrayList<>();

        when(doctorMapper.mapToDoctorDtoList(doctorService.getAll())).thenReturn(doctorDtos);
        // When & Then
        mockMvc.perform(get("/medical_clinic/doctor")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void createTest() throws Exception {
        // Given
        Doctor doctor = new Doctor(1L, "name", "lastname",
                "specialisation", "stars");
        DoctorDto doctorDto = new DoctorDto(1L, "name", "lastname",
                "specialisation", "review");

        when(doctorMapper.mapToDoctor(any())).thenReturn(doctor);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(doctorDto);
        // When & Then
        mockMvc.perform(post("/medical_clinic/doctor")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

        verify(doctorService).save(doctor);
    }

    @Test
    public void updateTest() throws Exception {
        // Given
        DoctorDto doctorDto = new DoctorDto(1L, "name", "lastname",
                "specialisation", "review");

        when(doctorMapper.mapToDoctorDto(doctorService.save(doctorMapper.mapToDoctor(doctorDto))))
                .thenReturn(doctorDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(doctorDto);
        // When & Then
        mockMvc.perform(put("/medical_clinic/doctor")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.review", is("review")));
    }

    @Test
    public void deleteTest() throws Exception {
        // Given
        Doctor doctor = new Doctor(1L, "name", "lastname",
                "specialisation", "stars");

        when(doctorService.get(doctor.getId())).thenReturn(Optional.of(doctor));
        // When & Then
        mockMvc.perform(delete("/medical_clinic/doctor/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(doctorService).deleteById(doctor.getId());
    }
}
