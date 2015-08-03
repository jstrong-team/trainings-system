package com.exadel.jstrong.web.fortrainings.controller;

/**
 * Created by Anton on 03.08.2015.
 */
public interface ParticipantController {

    void recordToMeets(int subscribeId, int trainingId);
    void deleteFromMeets(int subscribeId, int trainingId);
}
