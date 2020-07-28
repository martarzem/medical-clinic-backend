package com.crud.medicalclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Mail {
    private String sendTo;
    private String subject;
    private String message;
}
