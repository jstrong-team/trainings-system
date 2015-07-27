package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeFeedbackDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Anton on 23.07.2015.
 */
@Service
public class EmployeeFeedbackDAOImpl extends BaseDAO<EmployeeFeedback> implements EmployeeFeedbackDAO {

    @Override
    @Transactional
    public void addFeedback(EmployeeFeedback feedback){
        super.update(feedback);
    }

    @Override
    public List<EmployeeFeedback> getAllFeedbacks(int trainingId) {
        try {
            CriteriaQuery<EmployeeFeedback> query = em.getCriteriaBuilder().createQuery(EmployeeFeedback.class);
            Root<EmployeeFeedback> root = query.from(EmployeeFeedback.class);
            query.where(root.get("training_id").in(trainingId));
            return em.createQuery(query).getResultList();
        } catch(Throwable e){
            e.printStackTrace();
            return null;
        }
    }
}
