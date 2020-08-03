package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.domain.DoctorDto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DoctorMapperTest {
    private DoctorMapper doctorMapper;

    @Before
    public void beforeTest() {
        doctorMapper = new DoctorMapper();
    }

    @Test
    public void mapToDoctorTest() {
        // Given
        DoctorDto doctorDto = new DoctorDto(1L, "name", "lastname",
                "specialisation", "review");
        // When
        Doctor result = doctorMapper.mapToDoctor(doctorDto);
        // Then
        assertEquals(1L, result.getId());
        assertEquals("name", result.getName());
        assertEquals("lastname", result.getLastname());
        assertEquals("specialisation", result.getSpecialisation());
        assertEquals("review", result.getReview());
    }

    @Test
    public void mapToDoctorDtoTest() {
        // Given
        Doctor doctor = new Doctor(1L, "name", "lastname",
                "specialisation", "review");
        // When
        DoctorDto result = doctorMapper.mapToDoctorDto(doctor);
        // Then
        assertEquals(1L, result.getId());
        assertEquals("name", result.getName());
        assertEquals("lastname", result.getLastname());
        assertEquals("specialisation", result.getSpecialisation());
        assertEquals("review", result.getReview());
    }

    @Test
    public void mapToDoctorDtoListTest() {
        // Given
        List<Doctor> doctorList = new ArrayList<>();
        // When
        List<DoctorDto> result = doctorMapper.mapToDoctorDtoList(doctorList);
        // Then
        assertEquals(0, result.size());
    }
}
