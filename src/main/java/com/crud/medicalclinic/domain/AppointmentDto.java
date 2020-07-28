package com.crud.medicalclinic.domain;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
public class AppointmentDto {
    private long id;
    private Office office;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private String status;
    private List<String> purposes;

    @Getter
    public static class AppointmentDtoBuilder {
        private long id;
        private Office office;
        private Patient patient;
        private Doctor doctor;
        private LocalDate date;
        private String status;
        private List<String> purposes = new ArrayList<>();

        public AppointmentDtoBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public AppointmentDtoBuilder setOffice(Office office) {
            this.office = office;
            return this;

        }

        public AppointmentDtoBuilder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public AppointmentDtoBuilder setDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        public AppointmentDtoBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public AppointmentDtoBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public AppointmentDtoBuilder setPurposes(String purpose) {
            purposes.add(purpose);
            return this;
        }

        public AppointmentDto build() {
            return new AppointmentDto(id, office, patient, doctor, date, status, purposes);
        }
    }

    private AppointmentDto(long id, Office office, Patient patient, Doctor doctor,
                          LocalDate date, String status, List<String> purposes) {
        this.id = id;
        this.office = office;
        this.patient = patient;
        this.doctor = doctor;
        this.status = status;
        this.purposes = new ArrayList<>(purposes);
    }
}
