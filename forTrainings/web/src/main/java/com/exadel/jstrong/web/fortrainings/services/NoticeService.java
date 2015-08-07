package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.NoticeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.web.fortrainings.services.mailservice.Sender;
import com.exadel.jstrong.web.fortrainings.services.noticeservice.NoticeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 07.08.2015.
 */
@Component
public class NoticeService {

    @Autowired
    private EmployeeDAO eDAO;
    @Autowired
    private NoticeDAO noticeDAO;

    public void addNotices(Notice notice, List<Employee> employees) {
        noticeDAO.addNotice(notice);
        List<EmployeeNotice> en = NoticeFactory.getEmployeeNoticesFromEmployees(notice.getId(), employees);
        noticeDAO.addEmployeeNotices(notice.getId(), en);
        List<String> mails = eDAO.getEmployeesMails(employees);
        Sender.send(notice, mails);
    }


    public void addNotices(Notice notice, Employee employee) {
        noticeDAO.addNotice(notice);
        EmployeeNotice en = NoticeFactory.getEmployeeNoticeFromEmployee(notice.getId(), employee);
        List<EmployeeNotice> employeeNotices = new ArrayList<>();
        employeeNotices.add(en);
        noticeDAO.addEmployeeNotices(notice.getId(), employeeNotices);
        String mail = eDAO.getEmail(employee.getId());
        Sender.send(notice, mail);
    }
}
