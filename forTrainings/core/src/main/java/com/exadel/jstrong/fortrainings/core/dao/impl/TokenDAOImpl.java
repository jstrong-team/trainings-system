package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.fortrainings.core.model.Token;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by Maria on 20.07.2015.
 */
@Service
public class TokenDAOImpl extends BaseDAO<Token> implements TokenDAO {

    @Override
    @Transactional
    public void updateTokenByID(int employee_id, String value) {
        Token token = getTokenByEmployeeId(employee_id);
        token.setValue(value);

        em.merge(token);

    }

    private Token getTokenByEmployeeId(int employee_id) {
        Token token = (Token)em.createQuery("SELECT t FROM Token t WHERE t.employee_id = :employee_id").setParameter("employee_id", employee_id).getSingleResult();

        return token;
    }

    @Override
    public boolean checkToken(String value) {
        try {
            Token token = (Token) em.createQuery("SELECT t FROM Token t WHERE t.value = :value").setParameter("value", value).getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        finally {
        }
        return true;
    }

    @Override
    public int getIdByToken(String value) {
        int id = (int)em.createQuery("SELECT t.id FROM Token t WHERE t.value = :value").setParameter("value", value).getSingleResult();
        return id;
    }
}
