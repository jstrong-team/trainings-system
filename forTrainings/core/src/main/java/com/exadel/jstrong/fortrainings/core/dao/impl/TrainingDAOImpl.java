package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.SearchEvent;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TrainingDAOImpl extends BaseDAO<Training> implements TrainingDAO {

    private static Logger logger = Logger.getLogger(TrainingDAOImpl.class.getName());

    @Override
    public List<Event> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo) {
        List<Event> events = null;
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class);
            Root<Event> root = query.from(Event.class);
            query.where(criteriaBuilder.between(root.<String>get("date"), dateFrom, dateTo));
            query.orderBy(criteriaBuilder.asc(root.get("date")));
            events = em.createQuery(query).getResultList();

            String date = "";
            List<Integer> ids = (List<Integer>) em.createNativeQuery("SELECT training_id FROM subscribe WHERE employee_id = :id").setParameter("id", userId).getResultList();
            Event event = null;
            for(int i = 0; i < events.size(); i++) {
                System.out.println(events.get(i).getDate());
                event = events.get(i);
                event.setIsSubscribe(ids.contains(event.getTraining_id()));
                date = date.concat(event.getDate());
                event.setDate(date.substring(0, date.length() - 2));
                date = "";
            }
        } catch(Throwable e) {
            e.printStackTrace();
        }

        return events;
    }

    @Override
    public List<SearchEvent> getSearchResponse(String st) {

        Query query = em.createNativeQuery("SELECT meet.id, training.id as training_id, training.name, training.annotation, training.description, meet.date from  training join meet on meet.training_id = training.id where training.name like '%" + st + "%' or training.annotation like '%" + st + "%' or training.description like '%" + st + "%' order by meet.date", SearchEvent.class);

        List<SearchEvent> events = query.getResultList();
        String date = "";
        SearchEvent event = null;
        for(int i = 0; i < events.size(); i++) {
            event = events.get(i);
            date = date.concat(event.getDate());
            event.setDate(date.substring(0, date.indexOf('.')));
            date = "";
        }
        return events;

    }

    @Override
    @Transactional
    public int add (Training training){
        training = em.merge(training);
        return training.getId();
    }

    @Override
    @Transactional
    public Training getTrainingById(int id) {
        Training tr = null;
        tr = em.find(Training.class, id);
        Hibernate.initialize(tr.getFeedbacks());
        return tr;
    }

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
        return rate / feedbacks.size();
    }
}