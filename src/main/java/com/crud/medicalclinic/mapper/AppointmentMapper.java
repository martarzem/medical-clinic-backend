package com.crud.medicalclinic.mapper;

import com.crud.medicalclinic.domain.*;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment mapToAppointment(final AppointmentDto appointmentDto) {
        return new Appointment(
                appointmentDto.getId(),
                new Office(
                        appointmentDto.getOffice().getId(),
                        appointmentDto.getOffice().getNumber(),
                        appointmentDto.getPurpose()
                ),
                new Patient(
                        appointmentDto.getPatient().getId(),
                        appointmentDto.getPatient().getName(),
                        appointmentDto.getPatient().getLastname(),
                        appointmentDto.getPatient().getPesel()
                ),
                new Doctor(
                        appointmentDto.getDoctor().getId(),
                        appointmentDto.getDoctor().getName(),
                        appointmentDto.getDoctor().getLastname(),
                        appointmentDto.getDoctor().getSpecialisation(),
                        appointmentDto.getDoctor().getReview()
                ),
                appointmentDto.getDate(),
                appointmentDto.getPurpose(),
                appointmentDto.getStatus()
        );
    }

    public AppointmentDto mapToAppointmentDto(final Appointment appointment) {
        return new AppointmentDto(
                appointment.getId(),
                new Office(
                        appointment.getOffice().getId(),
                        appointment.getOffice().getNumber(),
                        appointment.getPurpose()
                ),
                new Patient(
                        appointment.getPatient().getId(),
                        appointment.getPatient().getName(),
                        appointment.getPatient().getLastname(),
                        appointment.getPatient().getPesel()
                ),
                new Doctor(
                        appointment.getDoctor().getId(),
                        appointment.getDoctor().getName(),
                        appointment.getDoctor().getLastname(),
                        appointment.getDoctor().getSpecialisation(),
                        appointment.getDoctor().getReview()
                ),
                appointment.getDate(),
                appointment.getPurpose(),
                appointment.getStatus()
        );
    }
}
