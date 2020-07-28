package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.OfficeDto;
import com.crud.medicalclinic.mapper.OfficeMapper;
import com.crud.medicalclinic.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical_clinic/office")
public class OfficeController {
    @Autowired
    private OfficeService officeService;
    @Autowired
    private OfficeMapper officeMapper;

    @GetMapping
    public List<OfficeDto> getAll() {
        return officeMapper.mapToOfficeDtoList(officeService.getAll());
    }

    @GetMapping("/{officeId}")
    public OfficeDto get(@PathVariable long officeId) throws IdNotFoundException {
        return officeMapper.mapToOfficeDto(officeService.get(officeId).orElseThrow(IdNotFoundException::new));
    }

    @PostMapping
    public void create(@RequestBody OfficeDto officeDto) {
        officeService.save(officeMapper.mapToOffice(officeDto));
    }

    @PutMapping
    public OfficeDto update(@RequestBody OfficeDto officeDto) {
        return officeMapper.mapToOfficeDto(officeService.save(officeMapper.mapToOffice(officeDto)));
    }

    @DeleteMapping("/{officeId}")
    public void delete(@PathVariable long officeId) throws IdNotFoundException {
        officeService.deleteById(officeId);
    }
}
