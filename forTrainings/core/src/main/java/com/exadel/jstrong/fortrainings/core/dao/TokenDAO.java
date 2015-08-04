package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Token;

import java.util.Date;

/**
 * Created by Maria on 20.07.2015.
 */
public interface TokenDAO extends GenericDAO<Token> {
    void updateTokenByID(int id, String token);
    boolean checkToken(String token);
    int getIdByToken(String token);
    void updateSession(int employeeId, String session);
    void updateDateBySession(String session, Date date);
    boolean checkSession(String session);
    int getIdBySession(String session);
    Date getDateBySession(String session);
    Token getTokenBySession(String session);
    void updateDate(int id, Date date);
    Token getTokenById(int id);
    void addToken(Token token);
    void deleteToken(Token token);
    void updatePathById(int id, String path);
}
