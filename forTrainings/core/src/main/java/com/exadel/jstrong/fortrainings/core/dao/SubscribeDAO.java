package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Subscribe;

import java.util.List;

public interface SubscribeDAO extends GenericDAO<Subscribe>{

    int addSubscribe(Subscribe subscribe);
    boolean removeSubscriber(int userId, int trainingId);
    boolean changeStatus(int trainingId);
    int contains(int userId, int trainingId);
    List<Subscribe> getSubscribersByEmployeeId(int employeeId);
}
