package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;

/**
 * Created by Maria on 20.07.2015.
 */

@Entity
@Table(name = "token")
public class Token {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", length = 45)
    private String value;

    @Column
    private Integer employee_id;

    @OneToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    public Token() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
}
