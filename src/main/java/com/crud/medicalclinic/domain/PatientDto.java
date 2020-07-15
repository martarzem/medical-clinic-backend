package com.crud.medicalclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private String name;
    private String lastname;
    private long pesel;
    private List<Appointment> appointments = new ArrayList<>();
}
