package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.PatientDto;
import com.crud.medicalclinic.mapper.PatientMapper;
import com.crud.medicalclinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical_clinic/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientMapper patientMapper;

    @GetMapping
    public List<PatientDto> getAll() {
        return patientMapper.mapToPatientDtoList(patientService.getAll());
    }

    @GetMapping("/{patientId}")
    public PatientDto get(@PathVariable long patientId) throws IdNotFoundException {
        return patientMapper.mapToPatientDto(patientService.get(patientId).orElseThrow(IdNotFoundException::new));
    }

    @PostMapping
    public void create(@RequestBody PatientDto patientDto) {
        patientService.save(patientMapper.mapToPatient(patientDto));
    }

    @PutMapping
    public PatientDto update(@RequestBody PatientDto patientDto) {
        return patientMapper.mapToPatientDto(patientService.save(patientMapper.mapToPatient(patientDto)));
    }

    @DeleteMapping("/{patientId}")
    public void delete(@PathVariable long patientId) throws IdNotFoundException {
        patientService.deleteById(patientId);
    }

}
