package com.exadel.jstrong.web.fortrainings.services.noticeservice;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.*;
import javafx.util.Pair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 30.07.2015.
 */
public class NoticeFactory {

    private static Logger logger = Logger.getLogger(NoticeFactory.class);
    public final static Integer systemId = 666;

    public static Notice getMeetByDelayNotice(Meet meet, Training training, Pair<Long, String> delay){
        try {
            Notice notice = new Notice();
            notice.setTheme("Meet is coming!");
            notice.setText("Meet of training \"" + training.getName() + "\" will be in " + delay.getValue());
            notice.setStatus("info");
            notice.setTrainingId(training.getId());
            Date date = new Date(meet.getDate().getTime() - delay.getKey());
            notice.setAddDate(date);
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getTrainingCreateNotice(Training training, int senderId){
        try {
            Notice notice = new Notice();
            notice.setTheme("New training");
            notice.setText("There is the new training " + training.getName() + " in system");
            notice.setStatus("info");
            notice.setSenderId(senderId);
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getTrainingEditNotice(Training training, int transactionId, int editorId){
        try {
            Notice notice = new Notice();
            notice.setTheme("Training edit");
            notice.setText("Training \"" + training.getName() + "\" was edited");
            notice.setStatus("info");
            notice.setSenderId(editorId);
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            notice.setTransactionId(transactionId);
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getTrainingDeleteNotice(Training training, Employee deleter){
        try {
            Notice notice = new Notice();
            notice.setTheme("Training delete");
            notice.setText("Training \"" + training.getName() + "\" was deleted");
            notice.setStatus("info");
            notice.setSenderId(deleter.getId());
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static List<EmployeeNotice> getEmployeeNoticesFromSubscribers(int noticeId, List<Subscribe> subscribers){
        EmployeeNotice employeeNotice;
        List<EmployeeNotice> employeeNotices = new ArrayList<>();
        for (Subscribe s : subscribers) {
            employeeNotice = new EmployeeNotice();
            employeeNotice.setEmployeeId(s.getEmployeeId());
            employeeNotice.setNoticeId(noticeId);
            employeeNotice.setComplete(false);
            employeeNotices.add(employeeNotice);
        }
        return employeeNotices;
    }

    public static EmployeeNotice getEmployeeNoticeFromSubscriber(int noticeId, Subscribe subscriber){
        EmployeeNotice employeeNotice;
        employeeNotice = new EmployeeNotice();
        employeeNotice.setEmployeeId(subscriber.getEmployeeId());
        employeeNotice.setNoticeId(noticeId);
        employeeNotice.setComplete(false);
        return employeeNotice;
    }

    public static List<EmployeeNotice> getEmployeeNoticesFromEmployees(int noticeId, List<Employee> employees){
        EmployeeNotice employeeNotice;
        List<EmployeeNotice> employeeNotices = new ArrayList<>();
        for (Employee s : employees) {
            employeeNotice = new EmployeeNotice();
            employeeNotice.setEmployeeId(s.getId());
            employeeNotice.setNoticeId(noticeId);
            employeeNotice.setComplete(false);
            employeeNotices.add(employeeNotice);
        }
        return employeeNotices;
    }

    public static EmployeeNotice getEmployeeNoticeFromEmployee(int noticeId, Employee employee){
        EmployeeNotice employeeNotice;
        employeeNotice = new EmployeeNotice();
        employeeNotice.setEmployeeId(employee.getId());
        employeeNotice.setNoticeId(noticeId);
        employeeNotice.setComplete(false);
        return employeeNotice;
    }

    public static Notice getNotApprovedNewTrainingNotice(Training training){
        try {
            Notice notice = new Notice();
            notice.setTheme("Approve training");
            notice.setText("Need approve of the new training \"" + training.getName() + "\"");
            notice.setStatus("warning");
            notice.setSenderId(training.getTrainer_id());
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getNotApprovedEditedTrainingNotice(Training training, int senderId, int transactionId) {
        try {
            Notice notice = new Notice();
            notice.setTheme("Approve training");
            notice.setText("Need approve changes in training \"" + training.getName() + "\"");
            notice.setStatus("warning");
            notice.setSenderId(senderId);
            notice.setTrainingId(training.getId());
            notice.setTransactionId(transactionId);
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getNewParticipantNotice(int senderId, Training training, String status) {
        try {
            Notice notice = new Notice();
            notice.setTheme("Addition successfully completed");
            notice.setText("You was added to the \"" + training.getName() + "\" participants list with status " + status);
            notice.setStatus("success");
            notice.setSenderId(senderId);
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getDeletedParticipantNotice(int senderId, Training training) {
        try {
            Notice notice = new Notice();
            notice.setTheme("Deletion completed");
            notice.setText("You was deleted from the \"" + training.getName() + "\" participants list");
            notice.setStatus("success");
            notice.setSenderId(senderId);
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getNewParticipantNotice(int senderId, Training training, String status, Employee employee) {
        try {
            Notice notice = new Notice();
            notice.setTheme("Addition successfully completed");
            notice.setText("User " + employee.getName() +  " was added to the \"" + training.getName() + "\" participants list with status " + status);
            notice.setStatus("success");
            notice.setSenderId(senderId);
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getDeletedParticipantNotice(int senderId, Training training, Employee employee) {
        try {
            Notice notice = new Notice();
            notice.setTheme("Deletion completed");
            notice.setText("User " + employee.getName() +  " was deleted from the \"" + training.getName() + "\" participants list");
            notice.setStatus("success");
            notice.setSenderId(senderId);
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getTrainerFeedbackNotice(Training training, Employee sender, Employee employee) {
        try {
            Notice notice = new Notice();
            notice.setTheme("New feedback");
            notice.setText("Trainer " + sender.getName() + " add new feedback about " + employee.getName() + " to the training \"" + training.getName() + "\"");
            notice.setStatus("info");
            notice.setSenderId(sender.getId());
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getEmployeeFeedbackNotice(Training training, Employee sender) {
        try {
            Notice notice = new Notice();
            notice.setTheme("New feedback");
            notice.setText("User " + sender.getName() + " add new feedback to the training \"" + training.getName() + "\"");
            notice.setStatus("info");
            notice.setSenderId(sender.getId());
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }
}
