package com.exadel.jstrong.fortrainings.core.model;

public class Training {

    private int id;
    private String name;
    private String annotation;
    private String data;
    private boolean isMine;

    /* ??
    private String targetAudience;
    private boolean isInternal;
    private boolean isPaid;*/

    public Training(int id, String name, String annotation, String data, boolean isUser) {
        this.id = id;
        this.name = name;
        this.annotation = annotation;
        this.data = data;
        this.isMine = isUser;
    //    this.trainerName = trainerName;
    //    this.description = description;
    //    this.duration = duration;
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

    public void setData(String data) {this.data = data;}

    public String getDate() {return data;}

    public void setIsUser(boolean isUser) {this.isMine = isUser;}

    public boolean getIsUser() {return isMine;}

    // public void setDuration(String duration) {this.duration = duration;}

    // public String getDuration() {return duration;}

    // public void setDescription(String description) {this.description = description;}

    // public String getDescription() {return description;}

    // public void setTrainerName(String trainerName) {this.trainerName = trainerName;}

    // public String getTrainerName() {return trainerName;}

}
