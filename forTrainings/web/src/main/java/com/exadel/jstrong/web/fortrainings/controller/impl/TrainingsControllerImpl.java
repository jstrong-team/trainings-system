package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.TrainingDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;

import java.util.List;

public class TrainingsControllerImpl implements TrainingsController {

    private TrainingDAO trainingDAO;

    public TrainingsControllerImpl() {
        trainingDAO = new TrainingDAOImpl();
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingDAO.getAll();
    }
}
