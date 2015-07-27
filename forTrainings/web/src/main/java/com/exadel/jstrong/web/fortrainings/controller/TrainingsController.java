package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.web.fortrainings.model.SearchEventUI;

import java.util.List;

public interface TrainingsController {
    List<Event> getAllTrainings(int userId);
    List<SearchEventUI> getSearchData(String str);
    boolean isTrainer(int uId, int tId);
}
