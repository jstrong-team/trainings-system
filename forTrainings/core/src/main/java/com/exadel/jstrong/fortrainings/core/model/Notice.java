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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", insertable = false, updatable = false)
    private Training training;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "notice")
    private List<EmployeeNotice> employeeNotices;

    public Notice() {
    }

    public Notice(String text) {
        this.text = text;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public List<EmployeeNotice> getEmployeeNotices() {
        return employeeNotices;
    }

    public void setEmployeeNotices(List<EmployeeNotice> employeeNotices) {
        this.employeeNotices = employeeNotices;
    }
}
