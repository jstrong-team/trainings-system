package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.RoleDAO;
import com.exadel.jstrong.fortrainings.core.model.Role;
import org.springframework.stereotype.Service;

/**
 * Created by Anton on 05.08.2015.
 */
@Service
public class RoleDAOImpl extends BaseDAO<Role> implements RoleDAO {

    @Override
    public int getRoleId(String value) {
        try{
            return (int)em.createNativeQuery("SELECT id WHERE name = :name").setParameter("name", value).getSingleResult();
        }catch(Throwable e){
            return 0;
        }
    }

    @Override
    public Role getRoleByName(String name) {
        try{
            return (Role)em.createQuery("SELECT r FROM Role r WHERE r.name = :name").setParameter("name", name).getSingleResult();
        }catch(Throwable e){
            return new Role();
        }
    }
}
