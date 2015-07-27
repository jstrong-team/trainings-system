package com.exadel.jstrong.fortrainings.core.dao;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 23.07.2015.
 */
public abstract class BaseDAO<T> implements GenericDAO<T>{

    private static Logger logger = Logger.getLogger(BaseDAO.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<T> getAll(Class<T> entityClass) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        return executeQuery(query);
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Transactional
    public boolean save (T entity){
        try {
            em.persist(entity);
            return true;
        } catch (Throwable e){
            logger.warn("Entity doesn't save");
            return false;
        }
    }

    public boolean delete (T entity){
        try{
            em.remove(entity);
            return true;
        } catch (Throwable e){
            logger.warn("Entity doesn't delete");
            return false;
        }
    }

    protected List<T> executeQuery(CriteriaQuery<T> query) {
        try {
            return em.createQuery(query).getResultList();
        } catch (Throwable e) {
            logger.warn("Could not execute query", e);
            return new ArrayList<T>();
        }
    }

    @Override
    public T getById(Class<T> entityClass, int id) {
        return em.find(entityClass, id);
    }

    public static String getCorrectDate(String date){
        return date.substring(0, date.indexOf('.'));
    }
}
