package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TransactionDAO;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.fortrainings.core.model.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Администратор on 30.07.2015.
 */
@Service
public class TransactionDAOImpl extends BaseDAO<Transaction> implements TransactionDAO {
    private static Logger logger = Logger.getLogger(TransactionDAOImpl.class.getName());

    @Override
    @Transactional
    public int add(Transaction transaction) {
        transaction = super.save(transaction);
        return transaction.getId();
    }

    @Override
    public Transaction getTransactionById(int id) {
        try {
            Transaction tr = getById(Transaction.class, id);
            return tr;
        } catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByParent(int parentId) {
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Transaction> query = criteriaBuilder.createQuery(Transaction.class);
            Root<Transaction> root = query.from(Transaction.class);
            query.where(criteriaBuilder.equal(root.<Integer>get("parentId"), parentId));
            return em.createQuery(query).getResultList();
        } catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
}
