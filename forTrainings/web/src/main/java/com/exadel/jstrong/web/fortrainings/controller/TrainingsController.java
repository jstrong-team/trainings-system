package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.Event;

import java.util.List;

public interface TrainingsController {
    List<Event> getAllTrainings(int userId);
    List<Event> getSearchData(String str);
}
