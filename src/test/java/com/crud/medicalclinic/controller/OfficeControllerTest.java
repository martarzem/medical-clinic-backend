package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.domain.OfficeDto;
import com.crud.medicalclinic.mapper.OfficeMapper;
import com.crud.medicalclinic.service.OfficeService;
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
@WebMvcTest(OfficeController.class)
public class OfficeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OfficeMapper officeMapper;
    @MockBean
    private OfficeService officeService;

    @Test
    public void getAllTest() throws Exception {
        // Given
        List<OfficeDto> officeDtos = new ArrayList<>();

        when(officeMapper.mapToOfficeDtoList(officeService.getAll())).thenReturn(officeDtos);
        // When & Then
        mockMvc.perform(get("/medical_clinic/office")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void getTest() throws Exception {
        // Given
        Office office = new Office(1L, 1, "description");

        OfficeDto officeDto = new OfficeDto(1L, 1, "description");

        when(officeService.get(office.getId())).thenReturn(Optional.of(office));
        when(officeMapper.mapToOfficeDto(office)).thenReturn(officeDto);
        // When & Then
        mockMvc.perform(get("/medical_clinic/office/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("description")));
    }

    @Test
    public void createTest() throws Exception {
        // Given
        Office office = new Office(1L, 1, "description");

        OfficeDto officeDto = new OfficeDto(1L, 1, "description");

        when(officeMapper.mapToOffice(any())).thenReturn(office);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(officeDto);
        // When & Then
        mockMvc.perform(post("/medical_clinic/office")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());

        verify(officeService).save(office);
    }

    @Test
    public void updateTest() throws Exception {
        // Given
        OfficeDto officeDto = new OfficeDto(1L, 1, "description");

        when(officeMapper.mapToOfficeDto(officeService.save(officeMapper.mapToOffice(officeDto))))
                .thenReturn(officeDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(officeDto);
        // When & Then
        mockMvc.perform(put("/medical_clinic/office")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("description")));
    }

    @Test
    public void deleteTest() throws Exception {
        // Given
        Office office = new Office(1L, 1, "description");

        when(officeService.get(office.getId())).thenReturn(Optional.of(office));
        // When & Then
        mockMvc.perform(delete("/medical_clinic/office/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(officeService).deleteById(office.getId());
    }
}
