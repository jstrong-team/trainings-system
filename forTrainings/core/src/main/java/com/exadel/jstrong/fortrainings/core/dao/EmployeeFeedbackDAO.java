package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;

public interface EmployeeFeedbackDAO extends GenericDAO<EmployeeFeedback>{

    void addFeedback(EmployeeFeedback feedback);

}
