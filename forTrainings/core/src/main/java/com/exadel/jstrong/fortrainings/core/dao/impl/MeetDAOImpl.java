package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.MeetDAO;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void add(Meet meet){
        em.merge(meet);
    }

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Predicate p1 = root.get("training_id").in(trainingId);
        Predicate p2 = cb.lessThan(root.<String>get("date"), dateFormat.format(date));
        query.where(em.getCriteriaBuilder().and(p1, p2));
        List<Meet> result = executeQuery(query);
        return !result.isEmpty();
    }

}
