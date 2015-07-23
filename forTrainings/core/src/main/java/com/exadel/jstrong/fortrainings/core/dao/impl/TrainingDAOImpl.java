package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.HibernateBaseDao;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.SearchEvent;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class TrainingDAOImpl extends HibernateBaseDao implements TrainingDAO {
    private static Logger logger = Logger.getLogger(TrainingDAOImpl.class.getName());

    @Override
    public List<Event> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo) {
        List<Event> events = null;
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class);
            Root<Event> root = query.from(Event.class);
            query.where(criteriaBuilder.between(root.<String>get("date"), dateFrom, dateTo));
            events = em.createQuery(query).getResultList();

            String date = "";
            List<Integer> ids = (List<Integer>) em.createNativeQuery("SELECT training_id FROM subscribe WHERE employee_id = :id").setParameter("id", userId).getResultList();
            Event event = null;
            for(int i = 0; i < events.size(); i++) {
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
//        em.getTransaction().begin();
        training = em.merge(training);
//        em.getTransaction().commit();
        return training.getId();
    }

    @Override
    public Training getTrainingById(int id) {
        Training tr = null;
        try {
            tr = em.find(Training.class, id);
        } catch(Exception e) {

        }
        return tr;
    }

    @Override
    public boolean isSubscribeById (int employeeId, int trainingId){

        try {
            String result = (String) em.createNativeQuery("select status from subscribe where training_id =:training_Id and employee_id =:employee_Id").setParameter("training_Id", trainingId).setParameter("employee_Id", employeeId).getSingleResult();
            if(result.compareTo("approve") == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

}