package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Token;

/**
 * Created by Maria on 20.07.2015.
 */
public interface TokenDAO extends GenericDAO<Token> {
    void updateTokenByID(int id, String token);
    boolean checkToken(String token);
    int getIdByToken(String token);
    Token addToken(Token token);
}
