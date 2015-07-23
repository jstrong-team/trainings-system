package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.fortrainings.core.model.Training;

/**
 * Created by ????????????? on 21.07.2015.
 */
public interface TrainingStorageController {
    Training getTraining(int tId, int uId);
    void addTraining(Training training);
}

