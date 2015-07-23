package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.MeetDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.MeetDAOImpl;
import com.exadel.jstrong.fortrainings.core.dao.impl.TrainingDAOImpl;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.TrainingStorageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainingStorageControllerImpl implements TrainingStorageController {

    @Autowired
    private TrainingDAO tDAO;
    @Autowired
    private MeetDAO mDAO;

    @Override
    public void addTraining(Training training) {
        int id = tDAO.add(training);
        List<String> dates = training.getDate();
        int size = dates.size();
        Meet meet = new Meet();
        for (int i = 0; i<size;i++){
            meet.setTraining_id(id);
            meet.setDate(dates.get(i));
            mDAO.add(meet);
        }
    }

    @Override
    public Training getTraining(int tId, int uId) {
        List<Meet> meets = mDAO.getMeetsByTrainingId(tId);
        int size = meets.size();
        List<String> dates = new ArrayList<String>(size);
        String date = "";
        for (int i = 0; i < size; i++){
            date = date.concat(meets.get(i).getDate());
            dates.add(date.substring(0, date.indexOf('.')));
            date = "";
        }
        Training training = tDAO.getTrainingById(tId);
        training.setDate(dates);
        training.setIsSubscribe(tDAO.isSubscribeById(tId, uId));

        return training;
    }
}
