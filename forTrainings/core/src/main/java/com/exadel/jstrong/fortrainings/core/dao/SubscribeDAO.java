package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Participant;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;

import java.util.List;

public interface SubscribeDAO extends GenericDAO<Subscribe>{

    int addSubscribe(Subscribe subscribe);
    boolean removeSubscriber(int userId, int trainingId);
    boolean changeStatusToApprove(int trainingId);
    boolean changeStatusToWait(int trainingId);
    int contains(int userId, int trainingId);
    List<Subscribe> getSubscribersByEmployeeId(int employeeId);
    List<Subscribe> getSubscribersByStatus(int trainingId, String status);
    int getApproveCount(int trainingId);
    List<String> getSubscribersEmailsByStatus(int trainingId, String status);
    List<Participant> getParticipantsByMeetIds(int subscribeId, List<Integer> meetIds);
    int getSubscribeIdToWait(int trainingId);
    int getSubscribeIdToApprove(int trainingId);
    List<Integer> getSubscribeIdsToWait(int trainingId, int count);
    boolean dateMeetChecker(int trainingId);
}
