package com.exadel.jstrong.fortrainings.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "new_view")
public class Event {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String annotation;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    @Transient
    private boolean isSubscribe;

    public Event() {
    }

    public Event(int id, String name, String annotation, String date, boolean isSubscribe) {
        this.id = id;
        this.name = name;
        this.annotation = annotation;
        this.date = date;
        this.isSubscribe = isSubscribe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAnnotation() {return annotation;}

    public void setDate(String date) {this.date = date;}

    public String getDate() {return date;}

    public void setIsUser(boolean isUser) {this.isSubscribe = isUser;}

    public boolean getIsUser() {return isSubscribe;}

}
