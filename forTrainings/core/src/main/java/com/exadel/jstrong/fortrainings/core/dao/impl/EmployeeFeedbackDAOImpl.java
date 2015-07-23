package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.EmployeeFeedbackDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import org.springframework.stereotype.Service;

/**
 * Created by Anton on 23.07.2015.
 */
@Service
public class EmployeeFeedbackDAOImpl extends BaseDAO<EmployeeFeedback> implements EmployeeFeedbackDAO {

    @Override
    public boolean addFeedback(EmployeeFeedback feedback){
        return super.save(feedback);
    }

}
