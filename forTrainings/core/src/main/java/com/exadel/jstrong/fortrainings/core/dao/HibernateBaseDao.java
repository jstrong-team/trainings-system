package com.exadel.jstrong.fortrainings.core.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Администратор on 22.07.2015.
 */
public abstract class HibernateBaseDao {
    @PersistenceContext
    protected EntityManager em;
}
