package com.exadel.jstrong.web.fortrainings.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anton on 05.08.2015.
 */
public class FeedbackReportUI {

    private String date;
    private String text;

    private final DateFormat formatter;

    public FeedbackReportUI(){
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = formatter.format(date);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString(){
        StringBuilder str = new StringBuilder(date);
        str.append(": \r\n").append(text);
        return str.toString();
    }

}
