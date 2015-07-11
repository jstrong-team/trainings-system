package com.exadel.jstrong.fortrainings.core.model;

public class Training {

    private String id;
    private String trainerName;
    private String name;
    private String annotation;
    private String description;
    private String duration;

    /* ??
    private String targetAudience;
    private boolean isInternal;
    private boolean isPaid;*/

    public Training(String id, String trainerName, String name, String annotation, String description, String duration) {
        this.id = id;
        this.trainerName = trainerName;
        this.name = name;
        this.annotation = annotation;
        this.description = description;
        this.duration = duration;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
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

    public String getAnnotation() {
        return annotation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

}
