package com.exadel.jstrong.web.fortrainings.model;

import java.util.List;

/**
 * Created by Администратор on 30.07.2015.
 */
public class TrainingReportUI {

    private int id;
    private String name;
    private List<UserReportUI> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserReportUI> getUsers() {
        return users;
    }

    public void setUsers(List<UserReportUI> users) {
        this.users = users;
    }
}
