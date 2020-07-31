package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AppointmentMapper {
    public Appointment mapToAppointment(final AppointmentDto.AppointmentDtoBuilder appointmentDto) {
        return new Appointment(
                appointmentDto.getId(),
                new Office(
                        appointmentDto.getOffice().getId(),
                        appointmentDto.getOffice().getNumber(),
                        appointmentDto.getOffice().getDescription()),
                new Patient(
                        appointmentDto.getPatient().getId(),
                        appointmentDto.getPatient().getName(),
                        appointmentDto.getPatient().getLastname(),
                        appointmentDto.getPatient().getPesel()),
                new Doctor(
                        appointmentDto.getDoctor().getId(),
                        appointmentDto.getDoctor().getName(),
                        appointmentDto.getDoctor().getLastname(),
                        appointmentDto.getDoctor().getSpecialisation(),
                        appointmentDto.getDoctor().getReview()),
                appointmentDto.getDate(),
                appointmentDto.getStatus(),
                appointmentDto.getPurposes());
    }

    public AppointmentDto mapToAppointmentDto(final Appointment appointment) {
        return new AppointmentDto.AppointmentDtoBuilder()
                .setId(appointment.getId())
                .setOffice(new Office(
                        appointment.getOffice().getId(),
                        appointment.getOffice().getNumber(),
                        appointment.getOffice().getDescription()))
                .setPatient(new Patient(
                        appointment.getPatient().getId(),
                        appointment.getPatient().getName(),
                        appointment.getPatient().getLastname(),
                        appointment.getPatient().getPesel()))
                .setDoctor(new Doctor(
                        appointment.getDoctor().getId(),
                        appointment.getDoctor().getName(),
                        appointment.getDoctor().getLastname(),
                        appointment.getDoctor().getSpecialisation(),
                        appointment.getDoctor().getReview()))
                .setDate(appointment.getDate())
                .setStatus(appointment.getStatus())
                .setPurposes(appointment.getPurposes().toString())
                .build();
    }

    public List<AppointmentDto> mapToAppointmentDtoList(final List<Appointment> appointmentList) {
        return appointmentList.stream()
                .map(a -> new AppointmentDto.AppointmentDtoBuilder()
                        .setId(a.getId())
                        .setOffice(new Office(
                                a.getOffice().getId(),
                                a.getOffice().getNumber(),
                                a.getOffice().getDescription()))
                        .setPatient(new Patient(
                                a.getPatient().getId(),
                                a.getPatient().getName(),
                                a.getPatient().getLastname(),
                                a.getPatient().getPesel()))
                        .setDoctor(new Doctor(
                                a.getDoctor().getId(),
                                a.getDoctor().getName(),
                                a.getDoctor().getLastname(),
                                a.getDoctor().getSpecialisation(),
                                a.getDoctor().getReview()))
                        .setDate(a.getDate())
                        .setStatus(a.getStatus())
                        .setPurposes(a.getPurposes().toString())
                        .build())
                        .collect(Collectors.toList());
    }
}
