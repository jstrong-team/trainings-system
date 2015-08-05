package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Role;

/**
 * Created by Anton on 05.08.2015.
 */
public interface RoleDAO {

    int getRoleId(String value);
    Role getRoleByName(String name);

}
