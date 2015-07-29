package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Anton on 23.07.2015.
 */
@Service
public class SubscribeDAOImpl extends BaseDAO<Subscribe> implements SubscribeDAO {

    @Override
    @Transactional
    public int addSubscribe(Subscribe subscribe){
        return super.save(subscribe).getId();
    }

    @Override
    @Transactional
    public boolean removeSubscriber(int userId, int trainingId) {
        try {
            Query query = em.createNativeQuery("update subscribe set status='deleted' where employee_id =:uId and training_id =:tId").setParameter("uId", userId).setParameter("tId", trainingId);
            query.executeUpdate();
            return true;
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean changeStatus(int trainingId) {
        try {
            Query query = em.createNativeQuery("update subscribe set status='approve' where status='wait' and training_id =:tId order by add_date limit 1").setParameter("tId", trainingId);
            query.executeUpdate();
            return true;
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return false;
    }


}
