package com.exadel.jstrong.web.fortrainings.services.mailservice;

/**
 * Created by Anton on 01.08.2015.
 */

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Sender {

    private static final String USERNAME = "antongrigorievd@gmail.com";
    private static final String PASSWORD = "IronFi72";
    private static Properties props;
    private static Session session;

    static {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }

    public void send(String subject, String text, String fromEmail, String toEmail, String filename){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            if (!filename.equals("")) {
                setFileAsAttachment(message, text, filename);
            } else {
                message.setText(text);
            }

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setFileAsAttachment(Message msg, String text, String filename) throws MessagingException {

        MimeBodyPart p1 = new MimeBodyPart();
        p1.setText(text);

        MimeBodyPart p2 = new MimeBodyPart();

        FileDataSource fds = new FileDataSource(filename);
        p2.setDataHandler(new DataHandler(fds));
        p2.setFileName(fds.getName());

        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p1);
        mp.addBodyPart(p2);

        msg.setContent(mp);
    }
}
