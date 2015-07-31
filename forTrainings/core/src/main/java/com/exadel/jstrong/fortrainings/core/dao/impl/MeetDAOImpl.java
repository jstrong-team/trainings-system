package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.MeetDAO;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 22.07.2015.
 */
@Service
public class MeetDAOImpl extends BaseDAO<Meet> implements MeetDAO {

    private static Logger logger = Logger.getLogger(MeetDAOImpl.class.getName());

    @Override
    @Transactional
    public void add(Meet meet){
        em.merge(meet);
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    public List<Meet> getMeetsByTrainingId(int trainingId){
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Meet> query = criteriaBuilder.createQuery(Meet.class);
            Root<Meet> root = query.from(Meet.class);
            query.where(criteriaBuilder.equal(root.<Integer>get("training_id"), trainingId));
            return em.createQuery(query).getResultList();
        } catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isGoing(int trainingId){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Meet> query = cb.createQuery(Meet.class);
        Root<Meet> root = query.from(Meet.class);

        Date date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Predicate p1 = root.get("training_id").in(trainingId);
        Predicate p2 = cb.lessThan(root.<Date>get("date"), date);
        query.where(em.getCriteriaBuilder().and(p1, p2));
        List<Meet> result = executeQuery(query);
        return !result.isEmpty();
    }


    @Override
    public void removeMeets(int trainingId) {
        try {
            Query query = em.createNativeQuery("delete from meet where training_id=:tId").setParameter("tId", trainingId);
            int res = query.executeUpdate();
            if(res == 0) {
                logger.info("No meets to change");
            }
        } catch (Throwable e) {
            logger.warn("Throwable exception.");
        }
    }

    @Override
    public List<Meet> getMeetsInDateScope(Date dateFrom, Date dateTo) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        List<Meet> events = null;
        try {
            CriteriaQuery<Meet> query = criteriaBuilder.createQuery(Meet.class);
            Root<Meet> root = query.from(Meet.class);
            query.where(criteriaBuilder.between(root.<Date>get("date"), dateFrom, dateTo));
            events = em.createQuery(query).getResultList();
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return events;
    }
}
