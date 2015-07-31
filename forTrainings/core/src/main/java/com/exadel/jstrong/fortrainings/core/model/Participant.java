package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ������������� on 31.07.2015.
 */
@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "subscribe_id")
    private Integer subscribeId;
    @Column(name = "absent")
    private Boolean absent;
    @Column(name = "date")
    private Date date;
    @Column(name = "reason")
    private String reason;

    public Integer getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Integer subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Boolean isAbsent() {
        return absent;
    }

    public void setAbsent(Boolean absent) {
        this.absent = absent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
