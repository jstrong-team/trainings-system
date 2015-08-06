package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainerFeedbackDAO;
import com.exadel.jstrong.fortrainings.core.model.TrainerFeedback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 04.08.2015.
 */
@Service
public class TrainerFeedbackDAOImpl extends BaseDAO<TrainerFeedback> implements TrainerFeedbackDAO {

    @Override
    @Transactional
    public void addFeedback(TrainerFeedback feedback) {
        super.update(feedback);
    }

    @Override
    public List<TrainerFeedback> getAllFeedbacks(int employeeId) {
        try {
            CriteriaQuery<TrainerFeedback> query = em.getCriteriaBuilder().createQuery(TrainerFeedback.class);
            Root<TrainerFeedback> root = query.from(TrainerFeedback.class);
            query.where(root.<Integer>get("employeeId").in(employeeId));
            return em.createQuery(query).getResultList();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TrainerFeedback> getTrainingFeedbacks(int employeeId, int trainingId) {
        try {
            CriteriaQuery<TrainerFeedback> query = em.getCriteriaBuilder().createQuery(TrainerFeedback.class);
            Root<TrainerFeedback> root = query.from(TrainerFeedback.class);
            Predicate p1 = root.<Integer>get("employeeId").in(employeeId);
            Predicate p2 = root.<Integer>get("trainingId").in(trainingId);
            query.where(em.getCriteriaBuilder().and(p1, p2));
            return em.createQuery(query).getResultList();
        } catch (Throwable e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
