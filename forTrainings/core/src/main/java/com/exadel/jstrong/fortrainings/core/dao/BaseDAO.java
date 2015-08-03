package com.exadel.jstrong.fortrainings.core.dao;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 23.07.2015.
 */
public abstract class BaseDAO<T> implements GenericDAO<T> {

    private static Logger logger = Logger.getLogger(BaseDAO.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<T> getAll(Class<T> entityClass) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> rootEntry = cq.from(entityClass);
            CriteriaQuery<T> all = cq.select(rootEntry);
            TypedQuery<T> allQuery = em.createQuery(all);
            return allQuery.getResultList();
        } catch (Throwable e) {
            logger.warn("Throwable");
        }
        return null;
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Transactional
    public T save(T entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Throwable e) {
            logger.warn(e.toString());
            logger.warn("Entity doesn't save");
            return null;
        }
    }

    @Transactional
    public void saveAll(List<T> entities) {
        for (T entity : entities)
            try {
                em.persist(entity);
            } catch (Throwable e) {
                logger.warn(e.toString());
                logger.warn("Entity doesn't save");
            }
    }

    @Transactional
    public boolean delete(T entity) {
        try {
            em.remove(entity);
            return true;
        } catch (Throwable e) {
            logger.warn("Entity doesn't delete");
            return false;
        }
    }

    @Transactional
    public void deleteAll(List<T> entities) {
        for (T entity : entities) {
            try {
                em.remove(entity);
            } catch (Throwable e) {
                logger.warn("Entity doesn't delete");
            }
        }
    }

    public boolean delete(Class<T> entityClass, int id) {
        T entity = em.find(entityClass, id);
        return delete(entity);
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

}
