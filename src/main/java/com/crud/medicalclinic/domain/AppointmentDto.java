package com.crud.medicalclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private long id;
    private Office office;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String purpose;
    private String status;
}
