package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.domain.DoctorDto;
import org.springframework.stereotype.Component;


@Component
public class DoctorMapper {
    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getName(),
                doctorDto.getLastname(),
                doctorDto.getSpecialisation(),
                doctorDto.getReview()

        );
    }

    public DoctorDto mapToDoctorDto(final Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getLastname(),
                doctor.getSpecialisation(),
                doctor.getReview()
        );
    }
}
