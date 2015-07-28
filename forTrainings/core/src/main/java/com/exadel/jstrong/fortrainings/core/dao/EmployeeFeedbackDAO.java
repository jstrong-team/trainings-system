package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;

import java.util.List;

public interface EmployeeFeedbackDAO extends GenericDAO<EmployeeFeedback>{

    void addFeedback(EmployeeFeedback feedback);
    List<EmployeeFeedback> getAllFeedbacks(int trainingId);
    boolean deleteFeedback(int id);
}
