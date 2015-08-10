package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Token;

/**
 * Created by Maria on 20.07.2015.
 */
public interface TokenDAO extends GenericDAO<Token> {
    void updateTokenByID(int id, String token);
    boolean checkToken(String token);
    int getIdByToken(String token);
    void updateSession(int employeeId, String session);
    boolean checkSession(String session);
    int getIdBySession(String session);
    Token getTokenBySession(String session);
    Token getTokenById(int id);
    void addToken(Token token);
    void deleteToken(Token token);
    void addTokenForEmployee(int id);
}
