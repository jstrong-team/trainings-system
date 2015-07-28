package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.service.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="meet")
public class Meet {

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private int training_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", insertable = false, updatable = false)
    private Training training;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraining_id() {
        return training_id;
    }

    public void setTraining_id(int training_id) {
        this.training_id = training_id;
    }

    @JsonSerialize(using= DateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}