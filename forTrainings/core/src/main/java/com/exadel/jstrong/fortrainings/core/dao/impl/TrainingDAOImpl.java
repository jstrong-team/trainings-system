package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.google.gson.Gson;
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

            List<Integer> ids = (List<Integer>) em.createNativeQuery("SELECT training_id FROM subscribe WHERE employee_id = :id").setParameter("id", userId).getResultList();
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
        Hibernate.initialize(training);
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
            e.printStackTrace();
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
        training.setApprove(false);
        Gson gson = new Gson();
        String json = gson.toJson(training);

        Query query = em.createNativeQuery("INSERT INTO transaction (old_id,json,entity_name) VALUES (?,?,?,?)");
        query.setParameter(1, training.getId());
        query.setParameter(2, json);
        query.setParameter(3, "Training");
        int res = query.executeUpdate();
        if (res == 0)
            logger.warn("editTraining: NO record inserted into transaction table.");
    }

    @Override
    @Transactional
    public void substituteTraining(int transactionID, boolean approve) {
        Query query;

        if (approve) {
            Training training = getTrainingByTransactionID(transactionID);
            update(training);
        }

        query = em.createNativeQuery("DELETE FROM transaction where id = ?");
        query.setParameter(1, transactionID);
        int res = query.executeUpdate();
        if (res == 0)
            logger.warn("substituteTraining: NO record deleted from transaction table.");
    }

    @Override
    @Transactional
    public Training getTrainingByTransactionID(int transactionID) {
        Query query;
        query = em.createNativeQuery("SELECT json FROM transaction where id = ?");
        query.setParameter(1, transactionID);
        String json = query.getSingleResult().toString();

        Gson gson = new Gson();
        Training training = gson.fromJson(json, Training.class);
        return training;
    }
}