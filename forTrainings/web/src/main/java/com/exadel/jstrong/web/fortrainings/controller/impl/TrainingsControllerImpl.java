package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.TrainingDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class TrainingsControllerImpl implements TrainingsController {

    private TrainingDAO trainingDAO;

    public TrainingsControllerImpl() {
        trainingDAO = new TrainingDAOImpl();
    }

    @Override
    public List<Event> getAllTrainings(int userId) {
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

        //List<Event> userEvents = trainingDAO.getUserTrainingsLast3MonthIsUser(userId, stringDateFrom, stringDateTo);
        List<Event> events = trainingDAO.getUserTrainingsLast3Month(userId, stringDateFrom, stringDateTo);
//        for(Event event : userEvents) {
//            event.setIsUser(true);
//        }
//        userEvents.addAll(notUserEvents);
        return events;
    }

    @Override
    public List<Event> getSearchData(String str) {
        return trainingDAO.getSearchResponse(str);
    }

}
