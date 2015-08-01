package com.exadel.jstrong.web.fortrainings.services.mailservice;

/**
 * Created by Anton on 01.08.2015.
 */

import com.exadel.jstrong.fortrainings.core.model.Notice;
import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;
import java.util.Properties;

public class Sender {

    private static Logger logger = Logger.getLogger(Sender.class);
    private static final String USERNAME = "antongrigorievd@gmail.com";
    private static final String PASSWORD = "IronFi72";
    private static final String SENDER = "jsTrong<antongrigorievd@gmail.com>";
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

    public static boolean send(Notice notice, String email) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(notice.getTheme());
            message.setText(notice.getText());
            Transport.send(message);
            return  true;
        } catch (MessagingException e) {
            logger.warn("Message didn't send");
            return false;
        }
    }

    public static boolean send(Notice notice, List<String> emails) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setSubject(notice.getTheme());
            message.setText(notice.getText());
            for (String email: emails) {
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                Transport.send(message);
            }
            return true;
        } catch (MessagingException e) {
            logger.warn("Messages didn't send");
            return false;
        }
    }

    public static boolean sendWithFile(Notice notice, String email, String filename) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(notice.getTheme());
            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText(notice.getText());
            MimeBodyPart p2 = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(filename);
            p2.setDataHandler(new DataHandler(fds));
            p2.setFileName(fds.getName());
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(p1);
            mp.addBodyPart(p2);
            message.setContent(mp);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            logger.warn("Message didn't send");
            return false;
        }
    }

    public static boolean sendWithFile(Notice notice, List<String> emails, String filename) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setSubject(notice.getTheme());
            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText(notice.getText());
            MimeBodyPart p2 = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(filename);
            p2.setDataHandler(new DataHandler(fds));
            p2.setFileName(fds.getName());
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(p1);
            mp.addBodyPart(p2);
            message.setContent(mp);
            for (String email: emails) {
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                Transport.send(message);
            }
            return true;
        } catch (MessagingException e) {
            logger.warn("Messages didn't send");
            return false;
        }
    }

}
