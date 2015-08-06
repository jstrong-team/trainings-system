package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.util.Generator;

/**
 * Created by Anton on 05.08.2015.
 */
public class ExternalService {

    public static Employee getExternalTrainer(Training training){
        Employee employee = new Employee();
        employee.setLogin(training.getExternalTrainerName());
        employee.setPassword(Generator.generateString(6));
        employee.setName(training.getExternalTrainerName());
        employee.setPhone(training.getExternalTrainerPhone());
        employee.setMail(training.getExternalTrainerMail());
        return employee;
    }

}
