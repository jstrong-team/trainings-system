package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Participant;

import java.util.List;

/**
 * Created by Anton on 03.08.2015.
 */
public interface ParticipantDAO {

    void addParticipants(List<Participant> participants);
    void deleteParticipants(List<Participant> participants);
    int contains(int subscribeId, int meetId);
    int updateParticipant(Participant participant);

}
