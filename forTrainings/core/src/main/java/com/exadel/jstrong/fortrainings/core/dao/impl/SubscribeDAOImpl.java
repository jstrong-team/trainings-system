package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Participant;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 23.07.2015.
 */
@Service
public class SubscribeDAOImpl extends BaseDAO<Subscribe> implements SubscribeDAO {

    private static Logger logger = Logger.getLogger(SubscribeDAOImpl.class.getName());

    @Override
    @Transactional
    public int addSubscribe(Subscribe subscribe) {
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
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getSubscribeIdToApprove(int trainingId) {
        try {
            Integer id = (Integer)em.createNativeQuery("select id from subscribe where status='Wait' and training_id =:tId order by add_date limit 1").setParameter("tId", trainingId).getSingleResult();
            return id;
        } catch (Throwable e) {
            logger.info("No subscribers by trainingId: " + trainingId);
        }
        return 0;
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    @Transactional
    public boolean changeStatusToApprove(int trainingId) {
        try {
            Query query = em.createNativeQuery("update subscribe set status='Approve' where status='Wait' and training_id =:tId order by add_date limit 1").setParameter("tId", trainingId);
            query.executeUpdate();
            return true;
        } catch (Throwable e) {
            logger.info("No subscribers by trainingId: " + trainingId);
        }
        return false;
    }

    @Override
    public int getApproveCount(int trainingId) {
        try {
            Query query = em.createNativeQuery("select * from subscribe where training_id =:tId and status='Approve'").setParameter("tId", trainingId);
            int count = query.getResultList().size();
            return count;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getSubscribeIdToWait(int trainingId) {
        try {
//            Integer id = (Integer)em.createNativeQuery("select id from subscribe where status='Approve' and training_id =:tId order by add_date desc limit 1").setParameter("tId", trainingId).getSingleResult();
            return getSubscribeIdsToWait(trainingId, 1).get(0);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Integer> getSubscribeIdsToWait(int trainingId, int count) {
        try {
            List<Integer> ids = em.createNativeQuery("select id from subscribe where status='Approve' and training_id =:tId order by add_date desc limit :amount")
                    .setParameter("tId", trainingId)
                    .setParameter("amount", count)
                    .getResultList();
            return ids;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ArrayList<Integer>();
    }


    @Override
    @Transactional
    public boolean changeStatusToWait(int trainingId) {
        try {
            Query query = em.createNativeQuery("update subscribe set status='Wait' where status='Approve' and training_id =:tId order by add_date desc limit 1").setParameter("tId", trainingId);
            query.executeUpdate();
            return true;
        } catch (Throwable e) {
            logger.info("No subscribers by trainingId: " + trainingId);
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

    @Override

    public List<Subscribe> getSubscribersByEmployeeId(int employeeId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        List<Subscribe> subscribes = null;
        try {
            CriteriaQuery<Subscribe> query = criteriaBuilder.createQuery(Subscribe.class);
            Root<Subscribe> root = query.from(Subscribe.class);
            query.where(criteriaBuilder.equal(root.<Integer>get("employeeId"), employeeId));
            subscribes = em.createQuery(query).getResultList();
            return subscribes;
        } catch (Throwable e) {
            logger.info("Nothing found by employeeId: " + employeeId);
        }
        return null;
    }

    @Override
    public List<Subscribe> getSubscribersByStatus(int trainingId, String status) {
        try {
            CriteriaQuery<Subscribe> query = em.getCriteriaBuilder().createQuery(Subscribe.class);
            Root<Subscribe> root = query.from(Subscribe.class);

            Predicate uId = root.get("trainingId").in(trainingId);
            Predicate tId = root.get("status").in(status);

            query.where(em.getCriteriaBuilder().and(uId, tId));
            return executeQuery(query);
        } catch (Throwable e) {
            return new ArrayList<Subscribe>();
        }
    }

    @Override
    public List<String> getSubscribersEmailsByStatus(int trainingId, String status) {
        try {
            return em.createNativeQuery("SELECT mail FROM employee WHERE id IN (SELECT employee_id FROM subscribe WHERE training_id = :id AND status = :status)").setParameter("id", trainingId).setParameter("status", status).getResultList();
        } catch (Throwable e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Participant> getParticipantsByMeetIds(int subscribeId, List<Integer> meetIds) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        List<Participant> participants = null;
        try {
            CriteriaQuery<Participant> query = criteriaBuilder.createQuery(Participant.class);
            Root<Participant> root = query.from(Participant.class);

            Predicate p1 = root.<Integer>get("subscribeId").in(subscribeId);
            Predicate p2 = root.<Integer>get("meetId").in(meetIds);

            query.where(criteriaBuilder.and(p1, p2));
            participants = em.createQuery(query).getResultList();
            return participants;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getSubscribersAsEmployees(int trainingId) {
        try{
            return em.createNativeQuery("SELECT * FROM employee WHERE id IN (SELECT employee_id FROM subscribe WHERE training_id = :tId AND status <> 'Deleted')", Employee.class).setParameter("tId", trainingId).getResultList();
        }catch(Throwable e){
            logger.warn(e.toString());
            return new ArrayList<>();
        }
    }

    //    public Integer get

    public boolean dateMeetChecker(int trainingId) {
        try {
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(Calendar.HOUR_OF_DAY, 1);
            Date hourAdd = cal.getTime();
            Query query = em.createNativeQuery("SELECT * FROM for_trainings.meet where date between ? and ? and training_id=:tId");
            query.setParameter(1, currentDate, TemporalType.TIMESTAMP);
            query.setParameter(2, hourAdd, TemporalType.TIMESTAMP);
            query.setParameter("tId", trainingId);
            int size = query.getResultList().size();

            if(size != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable e) {

        }
        return false;
    }

    @Override
    public Subscribe getSubscribe(int employeeId, int trainingId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        Subscribe subscribe = null;
        try {
            CriteriaQuery<Subscribe> query = criteriaBuilder.createQuery(Subscribe.class);
            Root<Subscribe> root = query.from(Subscribe.class);

            Predicate p1 = root.<Integer>get("employeeId").in(employeeId);
            Predicate p2 = root.<Integer>get("trainingId").in(trainingId);

            query.where(criteriaBuilder.and(p1, p2));
            subscribe = em.createQuery(query).getSingleResult();
            return subscribe;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
