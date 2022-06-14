/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electricbillgen;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author surya
 */
public class API {
    public static void sendMail(String recipent, String subject, String bodymessage) throws Exception{
        System.out.print("Preparing");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.hostinger.com");
        properties.put("mail.smtp.port", "587");
        
        String EmailDetails = "no-reply@echarge.ga";
        String password = "-va_Dzrg{t=W<8;t";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailDetails, password);
            }
            
        });
        Message message = prepareMessage(session, EmailDetails, recipent, subject, bodymessage);
        Transport.send(message);
        System.out.print("MEssage sent successfully");
    }
private static Message prepareMessage(Session session, String EmailDetails, String recipent, String subject, String bodymessage) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailDetails));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipent) );
            message.setSubject(subject);
            message.setText(bodymessage);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

