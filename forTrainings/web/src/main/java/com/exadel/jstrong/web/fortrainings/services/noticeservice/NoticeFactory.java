package com.exadel.jstrong.web.fortrainings.services.noticeservice;

import com.exadel.jstrong.fortrainings.core.model.*;
import javafx.util.Pair;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 30.07.2015.
 */
public class NoticeFactory {

    private static Logger logger = Logger.getLogger(NoticeFactory.class);

    public static Notice getMeetByDelayNotice(Meet meet, Training training, Pair<Long, String> delay){
        try {
            Notice notice = new Notice();
            notice.setTheme("Meet is coming!");
            notice.setText("Meet of training " + training.getName() + " will be in " + delay.getValue());
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

    public static Notice getTrainingCreateNotice(Training training){
        try {
            Notice notice = new Notice();
            notice.setTheme("New training");
            notice.setText("There is the new training " + training.getName() + " in system");
            notice.setStatus("info");
            notice.setSenderId(training.getTrainer_id());
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            return notice;
        } catch(Throwable e){
            logger.info("Error");
            return new Notice();
        }
    }

    public static Notice getTrainingEditNotice(Training training, Transaction transaction, Employee editor){
        try {
            Notice notice = new Notice();
            notice.setTheme("Training edit");
            notice.setText("Training " + training.getName() + "was edited");
            notice.setStatus("info");
            notice.setSenderId(editor.getId());
            notice.setTrainingId(training.getId());
            notice.setAddDate(new Date());
            notice.setTransactionId(transaction.getId());
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
            notice.setText("Training " + training.getName() + "was deleted");
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

}
