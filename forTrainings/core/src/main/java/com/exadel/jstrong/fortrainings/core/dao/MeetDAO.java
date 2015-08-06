package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Meet;

import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 22.07.2015.
 */
public interface MeetDAO extends GenericDAO<Meet>{

    int add(Meet meet);
    List<Meet> getMeetsByTrainingId(int id);

    boolean isGoing(int trainingId);
    void removeMeets(int trainingId);
    List<Meet> getMeetsInDateScope(Date dateFrom, Date dateTo);
    void deleteMeets(List<Meet> meets);
    int updateMeet(Meet meet);
}
