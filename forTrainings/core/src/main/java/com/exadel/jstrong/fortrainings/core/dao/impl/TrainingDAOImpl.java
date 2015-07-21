package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.db.ConnectionManager;
import com.exadel.jstrong.fortrainings.core.model.Event;
import org.apache.log4j.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.beans.Expression;
import java.sql.SQLException;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl implements TrainingDAO {
    private static Logger logger = Logger.getLogger(TrainingDAOImpl.class.getName());

    @Override
    public List<Event> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo) {
        em.getTransaction().begin();

        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class);
            Root<Event> root = query.from(Event.class);
            query.where(criteriaBuilder.between(root.<String>get("date"), dateFrom, dateTo));
            List<Event> events = em.createQuery(query).getResultList();

            //List<Event> events = new ArrayList<Event>();
            List<Integer> ids = (List<Integer>) em.createNativeQuery("SELECT training_id FROM subscribe WHERE employee_id = :id").setParameter("id", userId).getResultList();
            for (Event event : events) {
                event.setIsUser(ids.contains(event.getId()));
            }
            return events;
        } catch(Throwable e) {
            e.printStackTrace();
        }
        finally {
            em.getTransaction().commit();
        }
        return null;

       /* CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class);
        Root<Event> root = query.from(Event.class);
        //root.get("id").in(1,3,5,7);
        query.where(root.get("id").in(1,3,5,7));
        em.createQuery(query).getResultList();*/


        //Query query = em.createQuery("select t from Event t");
        //List<Event> events = query.getResultList();

        /*!!!!!!!
        em.getTransaction().begin();
        List<Integer> ids = (List<Integer>)em.createNativeQuery("SELECT training_id FROM subscribe WHERE employee_id = :id").setParameter("id", userId).getResultList();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class);
        Root<Event> root = query.from(Event.class);
        query.where(criteriaBuilder.between(root.<String>get("date"), dateFrom, dateTo));
        List<Event> events = em.createQuery(query).getResultList();
        */

        /*List<Event> events = new ArrayList<Event>();
        for(Integer id: ids) {
           // query.where(criteriaBuilder.in(root.get("id"), id));
            events.addAll(em.createQuery(query).getResultList());
        }*/
       /* CriteriaQuery<Subscribe> querySubscribe = criteriaBuilder.createQuery(Subscribe.class);
        Root<Subscribe> subscribeRoot = querySubscribe.from(Subscribe.class);
        query.where(criteriaBuilder.equal(subscribeRoot.<Integer>get("employee_id"), userId));*/

        /*em.getTransaction().begin();
        List<Event> events = em.createNativeQuery("SELECT training.id, training.name, training.annotation, meet.date FROM training, subscribe, meet where subscribe.employee_id <> :userId and subscribe.status = 'approve' and  training.id = subscribe.training_id and meet.training_id = training.id and meet.date between :dateFrom and :dateTo order by meet.date").setParameter("userId", userId).setParameter("dateFrom", dateFrom).setParameter("dateTo", dateTo).getResultList();
        em.getTransaction().commit();*/

        /*List<Event> list = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Event training = null;

        String sign = null;

        if (isUser) {
            sign = "=";
        } else {
            sign = "<>";
        }

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT training.id, training.name, training.annotation, meet.date FROM training, subscribe, meet where subscribe.employee_id "
                            + sign + userId + " and subscribe.status = 'approve' and  training.id = subscribe.training_id and meet.training_id = training.id and meet.date between ' "
                            + dateFrom + "' and '" + dateTo + "' order by meet.date;");
            while (resultSet.next()) {
                String buf = resultSet.getString("date");
                training = new Event(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("annotation"),
                        buf.substring(0, buf.length() - 2), false);
                list.add(training);
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

//    @Override
//    public List<Event> getUserTrainingsLast3MonthIsUser(int userId, String dateFrom, String dateTo) {
//        em.getTransaction().begin();
//        List<Event> events = em.createNativeQuery("SELECT training.id, training.name, training.annotation, meet.date FROM training, subscribe, meet where subscribe.employee_id = :userId and subscribe.status = 'approve' and  training.id = subscribe.training_id and meet.training_id = training.id and meet.date between :dateFrom and :dateTo order by meet.date").setParameter("userId", userId).setParameter("dateFrom", dateFrom).setParameter("dateTo", dateTo).getResultList();
//        em.getTransaction().commit();
//        return events;
//    }

    @Override
    public List<Event> getSearchResponse(String st) {

        em.getTransaction().begin();
        List<Event> events = em.createNativeQuery("SELECT training.id, training.name, training.annotation, training.description, meet.date from  training join meet on meet.training_id = training.id where training.name like '%" + st + "%' or training.annotation like '%" + st + "%' or training.description like '%" + st + "%' order by meet.date").getResultList();
        em.getTransaction().commit();
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