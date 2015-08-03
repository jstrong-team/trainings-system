package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.fortrainings.core.model.Transaction;

import java.util.List;

/**
 * Created by Администратор on 30.07.2015.
 */
public interface TransactionDAO extends GenericDAO<Transaction> {
    int add (Transaction transaction);
    Transaction getTransactionById(int id);
    List<Transaction> getTransactionsByParent(int parentId);
    boolean killTransaction(int transactionId);

}
