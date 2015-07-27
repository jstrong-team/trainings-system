package com.exadel.jstrong.web.fortrainings.model;

import com.exadel.jstrong.fortrainings.core.model.Event;

import java.util.List;

/**
 * Created by Администратор on 27.07.2015.
 */
public class TrainingsUI {
    private List<Event> actualTrainingsHistory;
    private List<Event> pastTrainingsHistory;

    public TrainingsUI() {
    }

    public List<Event> getActualTrainingsHistory() {
        return actualTrainingsHistory;
    }

    public void setActualTrainingsHistory(List<Event> actualTrainingsHistory) {
        this.actualTrainingsHistory = actualTrainingsHistory;
    }

    public List<Event> getPastTrainingsHistory() {
        return pastTrainingsHistory;
    }

    public void setPastTrainingsHistory(List<Event> pastTrainingsHistory) {
        this.pastTrainingsHistory = pastTrainingsHistory;
    }
}
