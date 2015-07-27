package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.TrainingDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.fortrainings.core.model.comparator.EventComp;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.model.SearchEventUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingsUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class TrainingsControllerImpl implements TrainingsController {

    @Autowired
    private TrainingDAO trainingDAO;

    public TrainingsControllerImpl() {
        trainingDAO = new TrainingDAOImpl();
    }

    @Override
    public TrainingsUI getAllTrainings(int userId) {
        Calendar calendarDateFrom = Calendar.getInstance();
        calendarDateFrom.set(Calendar.DAY_OF_MONTH, 1);
        calendarDateFrom.set(Calendar.HOUR, 0);
        calendarDateFrom.set(Calendar.MINUTE, 0);
        calendarDateFrom.set(Calendar.SECOND, 0);
        int currentMonth = calendarDateFrom.get(Calendar.MONTH);
        Date dateFrom = calendarDateFrom.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stringDateFrom = dateFormat.format(dateFrom);
        Calendar calendarDateTo = calendarDateFrom;
        calendarDateTo.set(Calendar.MONTH, currentMonth + 3);
        Date dateTo = calendarDateTo.getTime();
        String stringDateTo = dateFormat.format(dateTo);

        List<Event> events = trainingDAO.getTrainingsInDateScope(userId, stringDateFrom, stringDateTo);
        TrainingsUI tUI = new TrainingsUI();
        tUI.setActualTrainingsHistory(events);

        calendarDateTo = Calendar.getInstance();
        calendarDateTo.set(Calendar.DAY_OF_MONTH, 1);
        calendarDateTo.set(Calendar.HOUR, 0);
        calendarDateTo.set(Calendar.MINUTE, 0);
        calendarDateTo.set(Calendar.SECOND, 0);
        dateTo = calendarDateTo.getTime();
        stringDateTo = dateFormat.format(dateTo);
        calendarDateFrom = calendarDateTo;
        calendarDateFrom.set(Calendar.MONTH, currentMonth - 1);
        dateTo = calendarDateFrom.getTime();
        stringDateFrom = dateFormat.format(dateTo);
        events = trainingDAO.getTrainingsInDateScope(userId, stringDateFrom, stringDateTo);
        Collections.sort(events, new EventComp());
        tUI.setPastTrainingsHistory(events);

        return tUI;
    }

    @Override
    public List<SearchEventUI> getSearchData(String str) {
        List<Training> trainings =  trainingDAO.getSearchResponse(str);
        int size = trainings.size();
        List<SearchEventUI> events = new ArrayList<>();
        SearchEventUI event;
        Training training;
        List<String> dates;
        int count;
        for (int i=0;i<size;i++){
            dates = new ArrayList<>();
            event = new SearchEventUI();
            training = trainings.get(i);
            event.setId(training.getId());
            event.setAnnotation(training.getAnnotation());
            event.setName(training.getName());
            count = training.getMeets().size() - 1;
            dates.add(training.getMeets().get(0).getDate());
            if (count!=0) {
                dates.add(training.getMeets().get(count).getDate());
            }
            event.setDates(dates);
            events.add(event);
        }
        return events;
    }

    @Override
    public boolean isTrainer(int uId, int tId) {return trainingDAO.isTrainer(uId, tId);}

}
