package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.DoctorDto;
import com.crud.medicalclinic.mapper.DoctorMapper;
import com.crud.medicalclinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical_clinic/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorMapper doctorMapper;

    @GetMapping
    public List<DoctorDto> getAll() {
        return doctorMapper.mapToDoctorDtoList(doctorService.getAll());
    }

    @GetMapping("/{doctorId}")
    public DoctorDto get(@PathVariable long doctorId) throws IdNotFoundException {
        return doctorMapper.mapToDoctorDto(doctorService.get(doctorId).orElseThrow(IdNotFoundException::new));
    }

    @GetMapping("/{doctorLastname}")
    public List<DoctorDto> getByLastname(@PathVariable String doctorLastname) throws IdNotFoundException {
        return doctorMapper.mapToDoctorDtoList(doctorService.getByLastname(doctorLastname));
    }

    @PostMapping
    public void create(@RequestBody DoctorDto doctorDto) {
        doctorService.save(doctorMapper.mapToDoctor(doctorDto));
    }

    @PutMapping
    public DoctorDto update(@RequestBody DoctorDto doctorDto) {
        return doctorMapper.mapToDoctorDto(doctorService.save(doctorMapper.mapToDoctor(doctorDto)));
    }

    @DeleteMapping("/{doctorId}")
    public void delete(@PathVariable long doctorId) throws IdNotFoundException {
        doctorService.deleteById(doctorId);
    }
}
