package com.exadel.jstrong.web.fortrainings.services.mailservice;

/**
 * Created by Anton on 01.08.2015.
 */

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
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
    }

    public static boolean send(Notice notice, String email) {
        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(notice.getTheme());
            message.setContent(LetterFormService.getHTMLPage(notice), "text/html; charset=utf-8");
            Transport.send(message);
            return true;
        } catch (Throwable e) {
            logger.warn("Message didn't send");
            return false;
        }
    }

    public static boolean send(Notice notice, List<String> emails) {
        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            List<InternetAddress> tempList = new ArrayList<>();
            for (String email : emails){
                try {
                    tempList.add(InternetAddress.parse(email)[0]);
                }catch (Throwable e) {
                    logger.warn("Wrong mail address");
                }
            }
            InternetAddress[] addresses = new InternetAddress[tempList.size()];
            tempList.toArray(addresses);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setSubject(notice.getTheme());
            message.setContent(LetterFormService.getHTMLPage(notice), "text/html; charset=utf-8");
            message.setRecipients(Message.RecipientType.TO, addresses);
            Transport.send(message, addresses);
            return true;
        } catch (Throwable e) {
            logger.warn("Messages didn't send");
            return false;
        }
    }

    public static boolean sendWithFile(Notice notice, String email, String filename) {
        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
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
        } catch (Throwable e) {
            logger.warn("Message didn't send");
            return false;
        }
    }

    public static boolean sendWithFile(Notice notice, List<String> emails, String filename) {
        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            List<InternetAddress> tempList = new ArrayList<>();
            for (String email : emails){
                try {
                    tempList.add(InternetAddress.parse(email)[0]);
                }catch (Throwable e) {
                    logger.warn("Wrong mail address");
                }
            }
            InternetAddress[] addresses = new InternetAddress[tempList.size()];
            tempList.toArray(addresses);
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
            message.setRecipients(Message.RecipientType.TO, addresses);
            Transport.send(message, addresses);
            return true;
        } catch (Throwable e) {
            logger.warn("Messages didn't send");
            return false;
        }
    }

    public static boolean sendAccountData(Employee employee) {
        Notice notice = new Notice();
        notice.setTheme("Registration");
        StringBuilder text = new StringBuilder("You have been registered in the system as trainer.<br>");
        text.append("<br>Your login:");
        text.append(employee.getName());
        text.append("<br><br>Your password:");
        text.append(employee.getPassword());
        notice.setText(text.toString());
        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(employee.getMail()));
            message.setSubject("Registration");
            message.setContent(LetterFormService.getHTMLPage(notice), "text/html; charset=utf-8");
            Transport.send(message);
            return true;
        } catch (Throwable e) {
            logger.warn("Message didn't send");
            return false;
        }
    }

}
