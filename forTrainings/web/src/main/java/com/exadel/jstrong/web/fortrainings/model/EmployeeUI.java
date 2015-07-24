package com.exadel.jstrong.web.fortrainings.model;

/**
 * Created by Maria on 24.07.2015.
 */
public class EmployeeUI {

    private Integer id;
    private String name;

    public EmployeeUI() {
    }

    public EmployeeUI(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
