package com.crud.medicalclinic.service.mail;

import com.crud.medicalclinic.domain.Appointment;
import com.crud.medicalclinic.domain.Mail;
import com.crud.medicalclinic.repository.AppointmentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class MailScheduler {
    private static final String SUBJECT = "Appointments: once a day mail";

    @Autowired
    private MailService mailService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Value("${spring.mail.username}")
    private String adminMail;

    private String createMessage() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return "There is a list of today's appointments:" + appointments.toString();
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationMail() {
        mailService.sendMimeMessage(new Mail(
                getAdminMail(),
                SUBJECT,
                createMessage()
        ));
    }
}
