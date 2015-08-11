package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.fortrainings.core.model.Token;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Date;

/**
 * Created by Maria on 20.07.2015.
 */
@Service
public class TokenDAOImpl extends BaseDAO<Token> implements TokenDAO {

    Logger logger = Logger.getLogger(TokenDAOImpl.class);

    @Override
    @Transactional
    public void updateTokenByID(int employee_id, String value) {
        Token token = getTokenByEmployeeId(employee_id);
        token.setValue(value);
        em.merge(token);
    }

    private Token getTokenByEmployeeId(int employee_id) {
        Token token = (Token) em.createQuery("SELECT t FROM Token t WHERE t.employee_id = :employee_id").setParameter("employee_id", employee_id).getSingleResult();

        return token;
    }

    //TODO: add logger. Check finally block
    @Override
    public boolean checkToken(String value) {
        try {
            Token token = (Token) em.createQuery("SELECT t FROM Token t WHERE t.value = :value").setParameter("value", value).getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    @Override
    public int getIdByToken(String value) {
        try {
            int id = (int) em.createQuery("SELECT t.employee_id FROM Token t WHERE t.value = :value").setParameter("value", value).getSingleResult();
            return id;
        } catch (Throwable e) {
            return 0;
        }
    }

    @Override
    @Transactional
    public void updateSession(int employeeId, String session) {
        try {
            Token token = getTokenByEmployeeId(employeeId);
            token.setSession(session);
            em.merge(token);
        } catch (Throwable e){
            logger.warn(e.toString());
        }
    }

    @Override
    public Token getTokenBySession(String session) {
        Token token = (Token) em.createQuery("SELECT t FROM Token t WHERE t.session = :session").setParameter("session", session).getSingleResult();

        return token;
    }

    @Override
    public int getIdBySession(String session) {
        try {
            int id = (int) em.createQuery("SELECT t.employee_id FROM Token t WHERE t.session = :value").setParameter("value", session).getSingleResult();
            return id;
        } catch (Throwable e) {
            return 0;
        }
    }


    @Override
    public boolean checkSession(String session) {
        try {
            Token token = (Token) em.createQuery("SELECT t FROM Token t WHERE t.session = :value").setParameter("value", session).getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void addToken(Token token) {
        save(token);
    }

    @Override
    @Transactional
    public void deleteToken(Token token) {
        delete(token);
    }

    @Override
    public Token getTokenById(int id) {
        try {
            return getById(Token.class, id);
        } catch (Throwable e) {
            return null;
        }
    }

    @Override
    public void addTokenForEmployee(int id) {
        Token token = new Token();
        token.setEmployee_id(id);
        addToken(token);
    }
}
