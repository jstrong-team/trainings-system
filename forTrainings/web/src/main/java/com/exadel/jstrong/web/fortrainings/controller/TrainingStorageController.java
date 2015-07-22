package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.TrainingToAdd;

import java.util.List;

/**
 * Created by Администратор on 21.07.2015.
 */
public interface TrainingStorageController {
    List<Meet> toMeets(int id, List<String> dates);
    void addMeets(List<Meet> meets);
    void addTraining(TrainingToAdd tta);
}
