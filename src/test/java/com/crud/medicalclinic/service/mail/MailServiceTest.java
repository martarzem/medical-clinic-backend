package com.crud.medicalclinic.service.mail;

import com.crud.medicalclinic.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class MailServiceTest {
    @InjectMocks
    private MailService mailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void sendMailTest() {
        // Given
        Mail mail = new Mail("test@test.com", "Test", "Testing message");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getSendTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        // When
        mailService.sendMimeMessage(mail);
        // Then
        //assertEquals("test@test.com", mailMessage.getTo());
        assertEquals("Test", mailMessage.getSubject());
        assertEquals("Testing message", mailMessage.getText());
    }
}
