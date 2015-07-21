package com.exadel.jstrong.fortrainings.core.dao;

/**
 * Created by Maria on 20.07.2015.
 */
public interface TokenDAO extends HibernateDAO {
    void updateTokenByID(int id, String token);
    boolean checkToken(String token);
    int getIdByToken(String token);
}
