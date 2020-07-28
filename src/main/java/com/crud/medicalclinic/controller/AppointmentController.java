package com.crud.medicalclinic.controller;

import com.crud.medicalclinic.domain.*;
import com.crud.medicalclinic.mapper.AppointmentMapper;
import com.crud.medicalclinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medical_clinic/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @GetMapping
    public List<AppointmentDto> getAll() {
        return appointmentMapper.mapToAppointmentDtoList(appointmentService.getAll());
    }

    @GetMapping("/{appointmentId}")
    public AppointmentDto get(@PathVariable long appointmentId) throws IdNotFoundException {
        return appointmentMapper.mapToAppointmentDto(appointmentService.get(appointmentId)
                .orElseThrow(IdNotFoundException::new));
    }

    @PostMapping
    public void create(@RequestBody AppointmentDto.AppointmentDtoBuilder appointmentDto) {
        appointmentService.save(appointmentMapper.mapToAppointment(appointmentDto));
    }

    @PutMapping
    public AppointmentDto update(@RequestBody AppointmentDto.AppointmentDtoBuilder appointmentDto) {
        return appointmentMapper.mapToAppointmentDto(appointmentService.save(
                appointmentMapper.mapToAppointment(appointmentDto)));
    }

    @DeleteMapping("/{appointmentId}")
    public void delete(@PathVariable long appointmentId) throws IdNotFoundException {
        appointmentService.deleteById(appointmentId);
    }
}
