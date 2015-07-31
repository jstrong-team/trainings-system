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
    private Integer id;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "training_id")
    private Integer trainingId;

    private String text;

    @Column(name = "add_date")
    private String addDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    public TrainerFeedback() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
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
