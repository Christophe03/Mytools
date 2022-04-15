package com.example.MyTools.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;


    public void envoiEmail(String toEmail,
                           String subject,
                           String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mytoolsmaliodk@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);
        System.out.println("Mail envoyer avec Success ...");
    }
}
