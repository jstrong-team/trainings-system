package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.fortrainings.core.model.Token;

import javax.persistence.NoResultException;

/**
 * Created by Maria on 20.07.2015.
 */
public class TokenDAOImpl implements TokenDAO {
    @Override
    public void updateTokenByID(int employee_id, String value) {
        Token token = getTokenByEmployeeId(employee_id);
        token.setValue(value);
        em.getTransaction().begin();
        em.merge(token);
        em.getTransaction().commit();
    }

    private Token getTokenByEmployeeId(int employee_id) {
        em.getTransaction().begin();
        Token token = (Token)em.createQuery("SELECT t FROM Token t WHERE t.employee_id = :employee_id").setParameter("employee_id", employee_id).getSingleResult();
        em.getTransaction().commit();
        return token;
    }

    @Override
    public boolean checkToken(String value) {
//        em.getTransaction().begin();
        try {
            Token token = (Token) em.createQuery("SELECT t FROM Token t WHERE t.value = :value").setParameter("value", value).getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        finally {
//            em.getTransaction().commit();
        }
        return true;
    }

    @Override
    public int getIdByToken(String value) {
//        em.getTransaction().begin();
        int id = (int)em.createQuery("SELECT t.id FROM Token t WHERE t.value = :value").setParameter("value", value).getSingleResult();
//        em.getTransaction().commit();
        return id;
    }
}
