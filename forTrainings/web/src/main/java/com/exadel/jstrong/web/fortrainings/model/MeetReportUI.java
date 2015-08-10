package com.exadel.jstrong.web.fortrainings.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ������������� on 30.07.2015.
 */
public class MeetReportUI {
    private String date;
    private Boolean absent;
    private String reason;

    private final DateFormat formatter;

    public MeetReportUI(){
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = formatter.format(date);
    }

    @JsonSetter("date")
    public void setDate(String date){
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

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(date);
        if (absent != null && absent){
            str.append(" N");
        }
        if (reason != null){
            str.append("(").append(reason).append(")");
        }
        str.append("\r\n");
        return str.toString();
    }

}
