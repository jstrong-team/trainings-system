package com.exadel.jstrong.fortrainings.core.model;

public class Training {
    private String id;
    private String name;
    private String date;
    private String place;
    private String teacherName;
    private String description;
    private String targetAudience;
    private boolean isInternal;
    private boolean isPaid;

    public Training(String id, String name, String date, String place,
                    String teacherName, String description, String targetAudience,
                    boolean isInternal, boolean isPaid) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.teacherName = teacherName;
        this.description = description;
        this.targetAudience = targetAudience;
        this.isInternal = isInternal;
        this.isPaid = isPaid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setInternal(boolean isInternal) {
        this.isInternal = isInternal;
    }

    public boolean getInternal() {
        return isInternal;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean getPaid() {
        return isPaid;
    }


}
