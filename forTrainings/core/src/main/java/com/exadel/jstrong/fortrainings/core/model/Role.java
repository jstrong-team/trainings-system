package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Maria on 23.07.2015.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<Employee> employees;


    public Role() {
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

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
