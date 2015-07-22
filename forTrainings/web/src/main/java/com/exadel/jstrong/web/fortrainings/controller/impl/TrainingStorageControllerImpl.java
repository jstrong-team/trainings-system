package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.model.Meet;
//import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.fortrainings.core.model.TrainingData;
import com.exadel.jstrong.fortrainings.core.model.TrainingToAdd;
import com.exadel.jstrong.web.fortrainings.controller.TrainingStorageController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 21.07.2015.
 */
@Component
public class TrainingStorageControllerImpl implements TrainingStorageController {

    @Override
    public void addMeets(List<Meet> meets) {
        //todoDao
    }

    @Override
    public void addTraining(TrainingToAdd tta) {
        TrainingData t = new TrainingData(tta.getId(), tta.getName(), tta.getAnnotation(), tta.getDescription(), tta.getTarget(), tta.isPaid(), tta.getMax_participants(), tta.getPlace(), tta.isInternal());
        //todoDao
    }

    @Override
    public List<Meet> toMeets(int id, List<String> dates) {
        List<Meet> meets = new ArrayList(dates.size());
        int i = 0;
        for(Meet m: meets) {
            m.setTraining_id(id);
            m.setDate(dates.get(i));
            i++;
        }
        return meets;
    }
}
