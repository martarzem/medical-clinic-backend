package com.crud.medicalclinic.service;

import com.crud.medicalclinic.controller.OfficeController;
import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.repository.DoctorRepository;
import com.crud.medicalclinic.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAll() {
        return officeRepository.findAll();
    }

    public Optional<Office> get(long id) {
        return officeRepository.findById(id);
    }

    public Office save(Office office) {
        return officeRepository.save(office);
    }

    public void deleteById(long id) {
        officeRepository.deleteById(id);
    }
}
