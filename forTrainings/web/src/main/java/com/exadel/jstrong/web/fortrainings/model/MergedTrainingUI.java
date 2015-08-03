package com.exadel.jstrong.web.fortrainings.model;

import java.util.Date;
import java.util.List;

/**
 * Created by stas on 03.08.15.
 */
public class MergedTrainingUI {

    private String name;
    private String annotation;
    private String description;
    private String target;
    private String place;
    private boolean oldPaid;
    private boolean newPaid;
    private int oldMax_participants;
    private int newMax_participants;
    private boolean oldInternal;
    private boolean newInternal;
    private List<Date> oldDates;
    private List<Date> newDates;

    public MergedTrainingUI() {}

    public MergedTrainingUI(String name, String annotation, String description, String target, String place,
                            boolean oldPaid, boolean newPaid, int oldMax_participants, int newMax_participants,
                            boolean oldInternal, boolean newInternal, List<Date> oldDates, List<Date> newDates) {
        this.name = name;
        this.annotation = annotation;
        this.description = description;
        this.target = target;
        this.place = place;
        this.oldPaid = oldPaid;
        this.newPaid = newPaid;
        this.oldMax_participants = oldMax_participants;
        this.newMax_participants = newMax_participants;
        this.oldInternal = oldInternal;
        this.newInternal = newInternal;
        this.oldDates = oldDates;
        this.newDates = newDates;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return  annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public  void setTarget(String target) {
        this.target = target;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean getOldPaid() {
        return oldPaid;
    }

    public void setOldPaid(boolean oldPaid) {
        this.oldPaid=oldPaid;
    }

    public boolean getNewPaid() {
        return newPaid;
    }

    public void setNewPaid(boolean newPaid) {
        this.newPaid=newPaid;
    }

    public int getOldMax_participants() {
        return oldMax_participants;
    }

    public void setOldMax_participants(int oldMax_participants) {
        this.oldMax_participants = oldMax_participants;
    }

    public int getNewMax_participants() {
        return newMax_participants;
    }

    public void setNewMax_participants(int newMax_participants) {
        this.newMax_participants = newMax_participants;
    }

    public boolean getOldInternal() {
        return oldInternal;
    }

    public void setOldInternal(boolean oldInternal) {
        this.oldInternal = oldInternal;
    }

    public boolean getNewInternal() {
        return newInternal;
    }

    public void setNewInternal(boolean newInternal) {
        this.newInternal = newInternal;
    }

    public List<Date> getOldDates() {
        return oldDates;
    }

    public void setOldDates(List<Date> oldDates) {
        this.oldDates = oldDates;
    }

    public List<Date> getNewDates() {
        return newDates;
    }

    public void setNewDates(List<Date> newDates) {
        this.newDates = newDates;
    }
}
