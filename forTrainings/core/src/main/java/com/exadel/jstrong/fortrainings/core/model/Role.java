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
    private int id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "role")
    private List<EmployeeNotice> employeeNotices;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<EmployeeNotice> getEmployeeNotices() {
        return employeeNotices;
    }

    public void setEmployeeNotices(List<EmployeeNotice> employeeNotices) {
        this.employeeNotices = employeeNotices;
    }
}
