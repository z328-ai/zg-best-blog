package com.zgbest.zgBlogFront.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    public static String emailMessage = "目前是开发阶段，邮箱很简单";

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    public void sendEmail(String to) {
        String subject = "博客订阅";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(emailMessage);
        javaMailSender.send(message);
    }

//    public void sendEmail1() {
//        String subject = "博客订阅";
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(emailMessage);
//        javaMailSender.send(message);
//    }
}