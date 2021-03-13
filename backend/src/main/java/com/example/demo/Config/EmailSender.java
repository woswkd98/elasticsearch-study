package com.example.demo.Config;


import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.demo.common.RegexPattern;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class EmailSender {

    private RegexPattern pattern = new RegexPattern();

    private final String emailConfirmKey = "emailConfirmKey";

    String host = "smtp.naver.com";
    final String username = "woswkd98";
    final String password = "1231!";

    int port = 465;

    Session session = null;
    public static final String redisKey = "emailConfirm";
    @PostConstruct
    public void init() {

        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);

        session = Session.getInstance(props, new javax.mail.Authenticator() {
            String un = username;
            String pw = password;

            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(un, pw);
            }
        });
    }

    @PreDestroy
    public void destroy() {
        
    }

    public void sendMail(String email, int rand) {
        if(!pattern.isValidEmail(email)) {
            return;
        }

        Message mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("woswkd98@naver.com"));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            mimeMessage.setSubject("인증");
            mimeMessage.setText("인증번호  "  +  rand); 
            Transport.send(mimeMessage); 
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}