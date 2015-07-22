package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.SearchEvent;

import java.util.Date;
import java.util.List;

public interface TrainingDAO extends HibernateDAO{

    List<Event> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo);
    List<SearchEvent> getSearchResponse(String st);
}
