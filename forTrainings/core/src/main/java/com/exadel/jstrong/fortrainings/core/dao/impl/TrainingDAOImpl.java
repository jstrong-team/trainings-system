package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.*;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Service
public class TrainingDAOImpl extends BaseDAO<Training> implements TrainingDAO {

    private static Logger logger = Logger.getLogger(TrainingDAOImpl.class.getName());

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    public List<Event> getTrainingsInDateScope(int userId, Date dateFrom, Date dateTo) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        List<Event> events = null;
        try {
            CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class);
            Root<Event> root = query.from(Event.class);
            query.where(criteriaBuilder.between(root.<Date>get("date"), dateFrom, dateTo));
            query.orderBy(criteriaBuilder.asc(root.get("date")));
            events = em.createQuery(query).getResultList();

            List<Integer> ids = (List<Integer>) em.createNativeQuery("SELECT training_id FROM subscribe WHERE employee_id = :id AND status='Approve'").setParameter("id", userId).getResultList();
            List<Integer> trainerIds = (List<Integer>)em.createNativeQuery("SELECT id FROM training WHERE trainer_id =:uId").setParameter("uId", userId).getResultList();
            Event event;
            for(int i = 0; i < events.size(); i++) {
                event = events.get(i);
                event.setIsSubscribe(ids.contains(event.getTrainingId()));
                event.setIsTrainer(trainerIds.contains(event.getTrainingId()));
                event.setDate(event.getDate());
            }
        } catch(Throwable e) {
            e.printStackTrace();
        }

        return events;
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    @Transactional
    public List<Training> getSearchResponse(String st) {
        List<Training> trainings = null;
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Training> query = criteriaBuilder.createQuery(Training.class);
            Root<Training> root = query.from(Training.class);
            Predicate p1 = criteriaBuilder.like(root.<String>get("name"), "%" + st + "%");
            Predicate p2 = criteriaBuilder.like(root.<String>get("annotation"), "%" + st + "%");
            Predicate p3 = criteriaBuilder.like(root.<String>get("description"), "%" + st + "%");
            query.where(criteriaBuilder.or(p1, p2, p3));
            trainings = em.createQuery(query).getResultList();
            for (Training t: trainings){
                t.getMeets().size();
            }
        } catch(Throwable e){
            e.printStackTrace();
        }
        return trainings;
    }

    @Override
    @Transactional
    public int add (Training training){
        training = super.save(training);
        return training.getId();
    }

    @Override
    @Transactional
    public int updateTraining(Training training) {
        training = super.update(training);
        return training.getId();
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    @Transactional
    public Training getTrainingById(int id) {
        try {
            Training tr = getById(Training.class, id);
            Hibernate.initialize(tr.getFeedbacks());
            return tr;
        } catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    public boolean isSubscribeById (int employeeId, int trainingId){

        try {
            String result = (String) em.createNativeQuery("select status from subscribe where training_id =:training_Id and employee_id =:employee_Id").setParameter("training_Id", trainingId).setParameter("employee_Id", employeeId).getSingleResult();
            if(result.compareToIgnoreCase("approve") == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable e) {
            logger.info("Doesn't subscribe!");
        }
        return false;
    }

    @Override
    public boolean isTrainer(int userId, int trainingId){
        CriteriaQuery<Training> query = em.getCriteriaBuilder().createQuery(Training.class);
        Root<Training> root = query.from(Training.class);

        Predicate uId = root.get("trainer_id").in(userId);
        Predicate tId = root.get("id").in(trainingId);

        query.where(em.getCriteriaBuilder().and(uId, tId));
        List<Training> result = executeQuery(query);
        return !result.isEmpty();
    }

    @Override
    public boolean isApprove(int trainingId) {
        int maxParticipants = (Integer)em.createNativeQuery("SELECT max_participants FROM training WHERE id = :id").setParameter("id", trainingId).getSingleResult();
        int realParticipants = em.createNativeQuery("SELECT * FROM subscribe WHERE training_id = :id and status = 'approve'").setParameter("id", trainingId).getResultList().size();
        return (maxParticipants > realParticipants);
    }

    @Override
    @Transactional
    public int getRate(Training training) {
        List<EmployeeFeedback> feedbacks = training.getFeedbacks();
        int rate = 0;
        for(EmployeeFeedback ef: feedbacks) {
            rate += ef.getRate();
        }
        if(feedbacks.size() != 0) {
            return rate / feedbacks.size();
        } else {
            return 0;
        }
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    @Transactional
    public List<Subscribe> getSubscribers(int trainingId) {
        try {
            Training training = getById(Training.class, trainingId);
            Hibernate.initialize(training.getSubscribes());
            List<Subscribe> subscribers = training.getSubscribes();
            return subscribers;
        } catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public void editTraining(Training training) {
        int oldID, newID;

        oldID = training.getId();

        Training newTraining = new Training(training);
        newTraining.setApprove(false);
        newID = add(newTraining);

        Query query = em.createNativeQuery("INSERT INTO training_version VALUES (?,?)");
        query.setParameter(1, oldID);
        query.setParameter(2, newID);
        int res = query.executeUpdate();
        if (res == 0)
            logger.warn("NO record inserted into training_version table.");
    }


    public void changeStatus(int trainingId) {
        try {
            Query query = em.createNativeQuery("update training set approve=true training_id =:tId").setParameter("tId", trainingId);
            int res = query.executeUpdate();
            if(res == 0) {
                logger.info("No meets to change");
            }
        } catch (Throwable e) {
            logger.warn("Throwable exception.");
        }
    }

    @Override
    public String getTrainingName(int trainingId) {
        try {
            String name = em.createNativeQuery("select name from training where id=:tId").setParameter("tId", trainingId).getSingleResult().toString();
            return name;
        } catch (Throwable e) {
            logger.warn("Throwable exception.");
        }
        return null;
    }

    @Override
    public List<Participant> getAllBySubscribeId(int subscribeId) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        List<Participant> participants = null;
        try {
            CriteriaQuery<Participant> query = criteriaBuilder.createQuery(Participant.class);
            Root<Participant> root = query.from(Participant.class);
            query.where(criteriaBuilder.equal(root.<Integer>get("subscribeId"), subscribeId));
            participants = em.createQuery(query).getResultList();
            return participants;
        } catch(Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}