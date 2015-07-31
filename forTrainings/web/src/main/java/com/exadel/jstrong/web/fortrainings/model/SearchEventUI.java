package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.jsonutil.DateListSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 27.07.2015.
 */
public class SearchEventUI {
    
    public Integer id;
    public String name;
    public String annotation;
    public List<Date> dates;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    @JsonSerialize(using= DateListSerializer.class)
    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
