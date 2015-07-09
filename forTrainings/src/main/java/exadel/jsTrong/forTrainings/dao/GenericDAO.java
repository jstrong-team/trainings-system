package exadel.jsTrong.forTrainings.dao;


import java.util.List;

public interface GenericDAO<T> {

    T getByID(String ID);
    T update(T t);
    boolean save(T t);
    boolean delete(String id);
    List<T> getAll();
}