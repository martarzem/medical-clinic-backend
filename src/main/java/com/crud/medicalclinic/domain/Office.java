package com.crud.medicalclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office extends GenericEntity{
    private int number;
    private String description;
}
