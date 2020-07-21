package com.crud.medicalclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalClinicRepository<T> extends CrudRepository<T, Long> {
    @Override
    List<T> findAll();

    @Override
    Optional<T> findById(Long id);

    @Override
    <S extends T> S save(S entity);

    @Override
    void deleteById(Long id);


}
