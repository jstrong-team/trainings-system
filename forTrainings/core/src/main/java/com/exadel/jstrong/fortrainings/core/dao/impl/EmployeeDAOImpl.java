package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.HibernateBaseDao;
import com.exadel.jstrong.fortrainings.core.db.ConnectionManager;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.sql.*;

@Service
public class EmployeeDAOImpl extends HibernateBaseDao implements EmployeeDAO {
    private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());

    public Employee selectByAuthorization(String login, String password) {
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.login = :log  AND  e.password = :pas", Employee.class).setParameter("log", login).setParameter("pas", password);
        Employee employee = (Employee)query.getSingleResult();

        return employee;
    }
}