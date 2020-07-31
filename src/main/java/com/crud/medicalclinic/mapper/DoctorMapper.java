package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.Doctor;
import com.crud.medicalclinic.domain.DoctorDto;
import com.crud.medicalclinic.domain.Office;
import com.crud.medicalclinic.domain.OfficeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctorList) {
        return doctorList.stream()
                .map(d -> new DoctorDto(d.getId(), d.getName(), d.getLastname(), d.getSpecialisation(), d.getReview()))
                .collect(Collectors.toList());
    }
}
