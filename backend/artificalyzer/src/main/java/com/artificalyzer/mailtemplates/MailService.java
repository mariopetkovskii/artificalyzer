package com.artificalyzer.mailtemplates;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailService {
    private final static String host = "localhost";
    private final static int port = 1025;
    private final static String sender = "no-reply@artificalyzer.com";

    public static void emailConfirmation(String to,  String token) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, null);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://localhost:10101/rest/user/confirm-account?token=").append(token);
            message.setSubject("Account confirmation");
            message.setText(stringBuilder.toString());
            Transport.send(message);
        } catch (
                MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendMailRecoveryAccount(String email, String token){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, null);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Click here to recover your account http://localhost:10101/rest/user/recovery-password?token=").append(token);
            message.setSubject("Account Recovery");
            message.setText(stringBuilder.toString());
            Transport.send(message);
        } catch (
                MessagingException e) {
            e.printStackTrace();
        }
    }
}
