package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Maria on 24.07.2015.
 */
@Entity
@Table(name = "notice")
public class Notice {

    @Id
    private int id;

    @Column(name = "training_id")
    private int trainingId;

    private String text;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "notices")
    private List<Employee> employees;

    public Notice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
