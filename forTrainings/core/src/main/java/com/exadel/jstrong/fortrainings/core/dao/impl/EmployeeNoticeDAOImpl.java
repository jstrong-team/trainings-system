package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeNoticeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 30.07.15.
 */
@Service
public class EmployeeNoticeDAOImpl extends BaseDAO<EmployeeNotice> implements EmployeeNoticeDAO {

    @Override
    public List<Notice> getEmployeeActualNotices(int userId) {
        try {
            List<Notice> results = em.createNativeQuery("SELECT * FROM notice WHERE notice.id IN (SELECT id FROM employee_notice en WHERE en.complete = false AND en.employee_id = :id)", Notice.class).setParameter("id", userId).getResultList();
            return results;
        } catch(Throwable e) {
            return new ArrayList<Notice>();
        }
    }

    @Override
    public List<Notice> getEmployeeFirstHistoryNotices(int userId) {
        try {
            List<Notice> results = (List<Notice>)em.createNativeQuery("SELECT * FROM notice WHERE notice.id IN (SELECT id FROM employee_notice en WHERE en.complete = false AND en.employee_id = :id) LIMIT 50", Notice.class).setParameter("id", userId).getResultList();
            return results;
        } catch(Throwable e) {
            return new ArrayList<Notice>();
        }
    }

    @Override
    public List<Notice> getTrainingNotices(int trainingId) {

        TrainingDAO trainingDAO = new TrainingDAOImpl();
        Training training = trainingDAO.getById(Training.class, trainingId);
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
        try {
            return (int) em.createNativeQuery("SELECT COUNT(*) FROM employee_notice WHERE employee_id = :id AND complete = 0").setParameter("id", userId).getSingleResult();
        } catch (Throwable e) {
            return 0;
        }
    }

    @Override
    public int getHistoryNoticeCount(int userId) {
        try {
            return (int) em.createNativeQuery("SELECT COUNT(*) FROM employee_notice WHERE employee_id = :id AND complete = 1").setParameter("id", userId).getSingleResult();
        } catch (Throwable e) {
            return 0;
        }
    }
}