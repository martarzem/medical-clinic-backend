package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.domain.OfficeDto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OfficeMapperTest {
    private OfficeMapper officeMapper;

    @Before
    public void beforeTest() {
        officeMapper = new OfficeMapper();
    }

    @Test
    public void mapToOfficeTest() {
        // Given
        OfficeDto officeDto = new OfficeDto(1L, 1, "description");
        // When
        Office result = officeMapper.mapToOffice(officeDto);
        // Then
        assertEquals(1L, result.getId());
        assertEquals(1, result.getNumber());
        assertEquals("description", result.getDescription());
    }

    @Test
    public void mapToOfficeDtoTest() {
        // Given
        Office office = new Office(1L, 1, "description");
        // When
        OfficeDto result = officeMapper.mapToOfficeDto(office);
        // Then
        assertEquals(1L, result.getId());
        assertEquals(1, result.getNumber());
        assertEquals("description", result.getDescription());
    }

    @Test
    public void mapToOfficeDtoListTest() {
        // Given
        List<Office> officeList = new ArrayList<>();
        // When
        List<OfficeDto> result = officeMapper.mapToOfficeDtoList(officeList);
        // Then
        assertEquals(0, result.size());
    }
}
