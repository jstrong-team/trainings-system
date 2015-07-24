package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.model.enums.SubscribeStatus;

import javax.persistence.*;

/**
 * Created by Maria on 23.07.2015.
 */
@Entity
@Table(name = "subscribe")
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "training_id")
    private int trainingId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SubscribeStatus status;

    @Column(name = "add_date")
    private String addDate;

    public Subscribe() {
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

    public SubscribeStatus getStatus() {
        return status;
    }

    public void setStatus(SubscribeStatus status) {
        this.status = status;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }
}
