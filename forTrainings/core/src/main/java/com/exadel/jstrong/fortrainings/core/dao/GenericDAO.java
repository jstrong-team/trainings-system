package com.exadel.jstrong.fortrainings.core.dao;


import java.util.List;

public interface GenericDAO<T> {

    T getByID(String ID);
    boolean update(T t);
    boolean save(T t);
    boolean delete(String id);
    List<T> getAll();
}