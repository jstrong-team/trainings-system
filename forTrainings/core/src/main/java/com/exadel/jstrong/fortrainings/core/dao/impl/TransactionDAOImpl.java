package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.TransactionDAO;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Participant;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.fortrainings.core.model.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
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

    @Override
    public boolean killTransaction(int transactionId) {
        try {
            List<Integer> deleteIds = (List<Integer>) em.createNativeQuery("select id from transaction where id=:tId or parent_id=:tId")
                    .setParameter("tId", transactionId)
                    .getResultList();

            Query query = em.createNativeQuery("delete from transaction where id in :list").setParameter("list", deleteIds);
            int res = query.executeUpdate();
            if (res == 0) {
                logger.info("No trainings to change");
                return false;
            }
            return true;
        } catch (Throwable e) {
            logger.warn("Throwable exception.");
        }
        return false;
    }

    public List<Transaction> getAllTransactionsById(int transactionId) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Transaction> query = cb.createQuery(Transaction.class);
            Root<Transaction> root = query.from(Transaction.class);

            Predicate p1 = root.get("id").in(transactionId);
            Predicate p2 = root.get("parentId").in(transactionId);
            query.where(em.getCriteriaBuilder().or(p1, p2));
            List<Transaction> result = executeQuery(query);
            return result;
        } catch(Throwable e){
            logger.info("Nothing found!");
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteTransaction(List<Transaction> transactions) {
        deleteAll(transactions);
    }
}
