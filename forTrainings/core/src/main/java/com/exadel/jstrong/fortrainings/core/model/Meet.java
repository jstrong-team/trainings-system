package com.exadel.jstrong.fortrainings.core.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateDeserializer;
import com.exadel.jstrong.fortrainings.core.jsonutil.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    private Integer id;

    @Column
    private Integer training_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", insertable = false, updatable = false)
    private Training training;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Integer training_id) {
        this.training_id = training_id;
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getDate() {
        return date;
    }

    @JsonDeserialize(using= DateDeserializer.class)
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