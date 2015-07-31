package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Администратор on 31.07.2015.
 */
@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "subscribe_id")
    private int subscribeId;
    @Column(name = "absent")
    private boolean absent;
    @Column(name = "date")
    private Date date;
    @Column(name = "reason")
    private String reason;

    public int getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(int subscribeId) {
        this.subscribeId = subscribeId;
    }

    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
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
