package exadel.jsTrong.forTrainings.dao;


import java.util.List;

public interface GenericDAO<T> {
    /*
    //  void updateType(TYPE t);
    boolean selectByAuthorization(String login, String password);
    */

    T getByID(String ID);
    T update(T t);
    boolean save(T t);
    boolean delete(String id);
    List<T> getAll();
}