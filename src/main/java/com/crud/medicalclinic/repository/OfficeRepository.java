package com.crud.medicalclinic.repository;

import com.crud.medicalclinic.domain.Office;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OfficeRepository extends MedicalClinicRepository<Office> {
}
