package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeFeedbackDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Anton on 23.07.2015.
 */
@Service
public class EmployeeFeedbackDAOImpl extends BaseDAO<EmployeeFeedback> implements EmployeeFeedbackDAO {

    @Override
    @Transactional
    public void addFeedback(EmployeeFeedback feedback) {
        int id = contains(feedback.getEmployeeId(), feedback.getTrainingId());
        if (id != 0) {
            feedback.setId(id);
        }
        super.update(feedback);
    }
    
    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    public List<EmployeeFeedback> getAllFeedbacks(int trainingId) {
        try {
            CriteriaQuery<EmployeeFeedback> query = em.getCriteriaBuilder().createQuery(EmployeeFeedback.class);
            Root<EmployeeFeedback> root = query.from(EmployeeFeedback.class);
            query.where(root.<Integer>get("trainingId").in(trainingId));
            return em.createQuery(query).getResultList();
        } catch(Throwable e){
            e.printStackTrace();
            return null;
        }
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    @Transactional
    public boolean deleteFeedback(int id) {
        try {
            Query query = em.createNativeQuery("UPDATE employee_feedback SET isDelete = true WHERE id =:fId").setParameter("fId", id);
            query.executeUpdate();
            return true;
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int contains(int userId, int trainingId) {
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<EmployeeFeedback> query = criteriaBuilder.createQuery(EmployeeFeedback.class);
            Root<EmployeeFeedback> root = query.from(EmployeeFeedback.class);
            Predicate p1 = criteriaBuilder.equal(root.<Integer>get("trainingId"), trainingId);
            Predicate p2 = criteriaBuilder.equal(root.<Integer>get("employeeId"), userId);
            query.where(criteriaBuilder.and(p1, p2));
            EmployeeFeedback employeeFeedback = em.createQuery(query).getSingleResult();
            return employeeFeedback.getId();
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        }
    }
}
