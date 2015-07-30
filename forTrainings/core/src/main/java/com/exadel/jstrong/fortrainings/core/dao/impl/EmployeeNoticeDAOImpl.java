package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeNoticeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by stas on 30.07.15.
 */
public class EmployeeNoticeDAOImpl extends BaseDAO<EmployeeNotice> implements EmployeeNoticeDAO {

    @Override
    public List<Notice> getEmployeeNotices(Employee employee) {
        TypedQuery<Notice> query = em.createQuery("SELECT n FROM EmployeeNotice en INNER JOIN Notice n ON en.notice = n WHERE en.employee = :emp", Notice.class).setParameter("emp", employee);
        List<Notice> results = query.getResultList();

        return results;
    }

    @Override
    public List<Notice> getTrainingNotices(Training training) {
        TypedQuery<Notice> query = em.createQuery("SELECT n FROM EmployeeNotice en INNER JOIN Notice n ON en.notice = n WHERE n.training = :tr", Notice.class).setParameter("tr", training);
        List<Notice> results = query.getResultList();

        return results;
    }

    @Override
    public List<Notice> getCompletedEmployeeNotices() {
        // TODO
        return null;
    }

    @Override
    public int getNoticeCount(int userId) {
        return (int)em.createNativeQuery("SELECT COUNT(*) FROM employee_notice WHERE employee_id = :id AND complete = 1").setParameter("id", userId).getSingleResult();
    }
}