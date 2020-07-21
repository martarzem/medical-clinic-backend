package com.crud.medicalclinic.service;

import com.crud.medicalclinic.domain.Appointment;
import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.repository.AppointmentRepository;
import com.crud.medicalclinic.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> get(long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteById(long id) {
        appointmentRepository.deleteById(id);
    }
}
