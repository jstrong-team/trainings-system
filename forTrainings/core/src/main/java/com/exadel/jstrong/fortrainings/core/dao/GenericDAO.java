package com.exadel.jstrong.fortrainings.core.dao;

import java.util.List;

/**
 * Created by Anton on 23.07.2015.
 */
public interface GenericDAO<T> {

    T save (T entity);
    boolean delete (T entity);
    T update (T entity);
    List<T> getAll(Class<T> entityClass);
    T getById(Class<T> entityClass, int id);
}
