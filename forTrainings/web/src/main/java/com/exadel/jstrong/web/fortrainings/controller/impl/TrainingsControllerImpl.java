package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.TrainingDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.fortrainings.core.model.comparator.EventComp;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.model.EmployeeUI;
import com.exadel.jstrong.web.fortrainings.model.SearchEventUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingsUI;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class TrainingsControllerImpl implements TrainingsController {

    @Autowired
    private TrainingDAO trainingDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    public TrainingsControllerImpl() {
        trainingDAO = new TrainingDAOImpl();
    }

    //TODO: double database request? Why? Could we do this without treating DB?
    //TODO: and
    //TODO: 1) getTrainingsInDateScope(userId, dateFrom, dateTo);
    //TODO: 2) getTrainingsInDateScope(userId, dateTo, dateFrom); ????
    @Override
    public TrainingsUI getAllTrainings(int userId) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        int currentMonth = calendar.get(Calendar.MONTH);
        Date dateFrom = calendar.getTime();
        calendar.set(Calendar.MONTH, currentMonth + 3);
        Date dateTo = calendar.getTime();

        List<Event> events = trainingDAO.getTrainingsInDateScope(userId, dateFrom, dateTo);
        TrainingsUI tUI = new TrainingsUI();
        tUI.setActualTrainingsHistory(events);

        calendar.set(Calendar.MONTH, currentMonth);
        dateTo = calendar.getTime();
        calendar.set(Calendar.MONTH, currentMonth - 1);
        dateFrom = calendar.getTime();
        events = trainingDAO.getTrainingsInDateScope(userId, dateFrom, dateTo);
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
        List<Date> dates;
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

    @Override
    @Transactional
    public List<EmployeeUI> getUsersToReport() {
        List<EmployeeUI> employeeUIs = new ArrayList<>();
        List<Employee> employees = employeeDAO.getAllUsers();
        EmployeeUI employeeUI = null;
        int id;
        String name;
        for(Employee employee: employees) {
            employeeUI = new EmployeeUI();
            id = employee.getId();
            name = employee.getName();
            employeeUI.setId(id);
            employeeUI.setName(name);
            employeeUIs.add(employeeUI);
        }
        return employeeUIs;
    }

}
