package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Anton on 23.07.2015.
 */
@Service
public class SubscribeDAOImpl extends BaseDAO<Subscribe> implements SubscribeDAO {

    @Override
    @Transactional
    public int addSubscribe(Subscribe subscribe){
        int id = contains(subscribe.getEmployeeId(), subscribe.getTrainingId());
        if (id != 0) {
            subscribe.setId(id);
        }
        return super.update(subscribe).getId();
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    @Transactional
    public boolean removeSubscriber(int userId, int trainingId) {
        try {
            Query query = em.createNativeQuery("update subscribe set status='Deleted' where employee_id =:uId and training_id =:tId").setParameter("uId", userId).setParameter("tId", trainingId);
            query.executeUpdate();
            return true;
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    @Transactional
    public boolean changeStatus(int trainingId) {
        try {
            Query query = em.createNativeQuery("update subscribe set status='Approve' where status='Wait' and training_id =:tId order by add_date limit 1").setParameter("tId", trainingId);
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
            CriteriaQuery<Subscribe> query = criteriaBuilder.createQuery(Subscribe.class);
            Root<Subscribe> root = query.from(Subscribe.class);
            Predicate p1 = criteriaBuilder.equal(root.<Integer>get("trainingId"), trainingId);
            Predicate p2 = criteriaBuilder.equal(root.<Integer>get("employeeId"), userId);
            query.where(criteriaBuilder.and(p1, p2));
            Subscribe subscribe = em.createQuery(query).getSingleResult();
            return subscribe.getId();
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        }
    }

}
