package com.crud.medicalclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends GenericEntity {
    private String name;
    private String lastname;
    private String specialisation;
    private List<Appointment> appointments = new ArrayList<>();
}
