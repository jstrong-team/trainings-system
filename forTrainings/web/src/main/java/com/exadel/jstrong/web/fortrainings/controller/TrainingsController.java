package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.SearchEvent;

import java.util.List;

public interface TrainingsController {
    List<Event> getAllTrainings(int userId);
    List<SearchEvent> getSearchData(String str);
}
