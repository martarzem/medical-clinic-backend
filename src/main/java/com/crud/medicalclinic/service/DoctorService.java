package com.crud.medicalclinic.service;

import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.domain.Patient;
import com.crud.medicalclinic.repository.DoctorRepository;
import com.crud.medicalclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> get(long id) {
        return doctorRepository.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteById(long id) {
        doctorRepository.deleteById(id);
    }
}
