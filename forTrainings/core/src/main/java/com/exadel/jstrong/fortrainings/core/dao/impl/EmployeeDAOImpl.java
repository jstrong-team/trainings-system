package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class EmployeeDAOImpl extends BaseDAO<Employee> implements EmployeeDAO {
    private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class.getName());

    @Override
    public Employee selectByAuthorization(String login, String password) {
        Query query = em.createQuery("SELECT e FROM Employee e WHERE e.login = :log  AND  e.password = :pas", Employee.class).setParameter("log", login).setParameter("pas", password);
        Employee employee = (Employee)query.getSingleResult();

        return employee;
    }

    @Override
    public String getNameById(int id){
        Query query = em.createQuery("SELECT name FROM Employee WHERE id = :id").setParameter("id", id);
        return (String)query.getSingleResult();
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @Override
    public boolean isAdmin(int id) {
        try {
            List<String> roles = em.createNativeQuery("SELECT name FROM role, employee_role WHERE role.id = employee_role.role_id and employee_role.employee_id = :userId").setParameter("userId", id).getResultList();
            return roles.contains("admin");
        } catch (Throwable e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employee> getAllUsers() {
        return super.getAll(Employee.class);
    }

    @Override
    public String getEmail(int id) {
        Employee em = getById(Employee.class, id);
        return em.getMail();
    }

    @Override
    public List<String> getAllMails() {
        return em.createNativeQuery("SELECT mail FROM employee").getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        super.update(employee);
    }
}