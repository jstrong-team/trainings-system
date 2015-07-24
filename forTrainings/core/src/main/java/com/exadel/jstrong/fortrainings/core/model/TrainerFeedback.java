package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;

/**
 * Created by Maria on 24.07.2015.
 */
@Entity
@Table(name = "trainer_feedback")
public class TrainerFeedback {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "training_id")
    private int trainingId;

    private String text;

    @Column(name = "add_date")
    private String addDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    public TrainerFeedback() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
