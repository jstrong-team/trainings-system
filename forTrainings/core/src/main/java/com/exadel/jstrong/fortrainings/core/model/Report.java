package com.exadel.jstrong.fortrainings.core.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Anton on 06.08.2015.
 */
@Entity
@Table(name = "report")
public class Report {

    @Id
    @Column
    @Cascade({})
    private Integer id;

    @Column(name="subscribe_id")
    private Integer subscribeId;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private Boolean absent;

    @Column
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Integer subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean isAbsent() {
        return absent;
    }

    public void setAbsent(Boolean absent) {
        this.absent = absent;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
