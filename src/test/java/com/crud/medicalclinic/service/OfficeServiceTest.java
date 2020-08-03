package com.crud.medicalclinic.service;

import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.repository.OfficeRepository;
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
public class OfficeServiceTest {

    @InjectMocks
    private OfficeService officeService;
    @Mock
    private OfficeRepository officeRepository;

    @Test
    public void getAllTest() {
        // Given
        List<Office> officeList = new ArrayList<>();
        // When
        when(officeRepository.findAll()).thenReturn(officeList);
        List<Office> result = officeService.getAll();
        // Then
        assertEquals(0, result.size());
    }

    @Test
    public void getTest() {
        // Given
        Office office = new Office(1L, 1, "description");
        // When
        when(officeRepository.findById(1L)).thenReturn(java.util.Optional.of(office));
        Optional<Office> result = officeService.get(office.getId());
        // Then
        assertEquals("description", result.get().getDescription());
    }

    @Test
    public void saveTest() {
        // Given
        Office office = new Office(1L, 1, "description");
        // When
        when(officeRepository.save(office)).thenReturn(office);
        Office result = officeService.save(office);
        // Then
        assertEquals("description", result.getDescription());
    }

    @Test
    public void deleteTest() {
        // Given
        Office office = new Office(1L, 1, "description");

        // When
        officeService.deleteById(office.getId());
        // Then
        verify(officeRepository, times(1)).deleteById(office.getId());
    }
}
