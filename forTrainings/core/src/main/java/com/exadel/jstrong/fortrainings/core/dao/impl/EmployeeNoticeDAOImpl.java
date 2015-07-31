package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeNoticeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeNotice;
import com.exadel.jstrong.fortrainings.core.model.Notice;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 30.07.15.
 */
@Service
public class EmployeeNoticeDAOImpl extends BaseDAO<EmployeeNotice> implements EmployeeNoticeDAO {

    Logger logger = Logger.getLogger(EmployeeNoticeDAO.class);

    @Override
    public List<Notice> getEmployeeActualNotices(int userId) {
        try {
            List<Notice> results = em.createNativeQuery("SELECT * FROM notice WHERE notice.id IN (SELECT id FROM employee_notice en WHERE en.complete = false AND en.employee_id = :id)", Notice.class).setParameter("id", userId).getResultList();
            return results;
        } catch (Throwable e) {
            return new ArrayList<Notice>();
        }
    }

    @Override
    public List<Notice> getEmployeeHistoryNoticesByPage(int userId, int limitFrom, int limitCount) {
        try {
            List<Notice> results = (List<Notice>) em.createNativeQuery("SELECT * FROM notice WHERE notice.id IN (SELECT id FROM employee_notice en WHERE en.complete = true AND en.employee_id = :id) ORDER BY notice.add_date LIMIT :l1, :l2", Notice.class).setParameter("id", userId).setParameter("l1", limitFrom).setParameter("l2", limitCount).getResultList();
            return results;
        } catch (Throwable e) {
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
            List<EmployeeNotice> result;
            result = em.createNativeQuery("SELECT * FROM employee_notice WHERE employee_id = :id AND complete = 0").setParameter("id", userId).getResultList();
            return result.size();
        } catch (Throwable e) {
            return 0;
        }
    }

    @Override
    public int getHistoryNoticeCount(int userId) {
        try {
            List<EmployeeNotice> result;
            result = em.createNativeQuery("SELECT * FROM employee_notice WHERE employee_id = :id AND complete = 1").setParameter("id", userId).getResultList();
            return result.size();
        } catch (Throwable e) {
            return 0;
        }
    }

    @Override
    @Transactional
    public boolean markAsComplete(int userId, int noticeId) {
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<EmployeeNotice> query = criteriaBuilder.createQuery(EmployeeNotice.class);
            Root<EmployeeNotice> root = query.from(EmployeeNotice.class);
            Predicate uId = root.get("employeeId").in(userId);
            Predicate nId = root.get("noticeId").in(noticeId);
            query.where(criteriaBuilder.and(uId, nId));
            EmployeeNotice en = em.createQuery(query).getSingleResult();
            Hibernate.initialize(en);
            en.setComplete(true);
            return true;
        } catch (Throwable e) {
            return false;
        }
    }

    @Override
    @Transactional
    public int add(EmployeeNotice employeeNotice) {
        try {
            employeeNotice = save(employeeNotice);
            return employeeNotice.getId();
        } catch(Throwable e){
            logger.warn(e.toString());
            return 0;
        }
    }
}