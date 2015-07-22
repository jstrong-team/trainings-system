package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.db.ConnectionManager;
import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.SearchEvent;
import org.apache.log4j.Logger;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import java.sql.*;

import java.util.*;
import java.util.Date;

public class TrainingDAOImpl implements TrainingDAO {
    private static Logger logger = Logger.getLogger(TrainingDAOImpl.class.getName());

    @Override
    public List<Event> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo) {
//        em.getTransaction().begin();
        List<Event> events = null;
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class);
            Root<Event> root = query.from(Event.class);
            query.where(criteriaBuilder.between(root.<String>get("date"), dateFrom, dateTo));
            events = em.createQuery(query).getResultList();

            String date = "";
            List<Integer> ids = (List<Integer>) em.createNativeQuery("SELECT training_id FROM subscribe WHERE employee_id = :id").setParameter("id", userId).getResultList();
//            em.getTransaction().commit();
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

       // em.getTransaction().begin();
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
//        em.getTransaction().commit();
        return events;
        /*List<Event> list = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Event event = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT training.id, training.name, training.annotation, training.description, meet.date from  training join meet on meet.training_id = training.id where training.name like '%" + st + "%' or training.annotation like '%" + st + "%' or training.description like '%" + st + "%' order by meet.date");
            while (resultSet.next()) {
                String buf = resultSet.getString("date");
                event = new Event(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("annotation"),
                        buf.substring(0, buf.length() - 2), false);
                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
        return list;*/
    }
}