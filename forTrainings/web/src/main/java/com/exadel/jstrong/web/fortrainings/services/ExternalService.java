package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * Created by Anton on 05.08.2015.
 */
public class ExternalService {

    public static Employee getExternalTrainer(Training training){
        String login = training.getExternalTrainerName();
        login = login + (new Random()).nextInt(100);
        Employee employee = new Employee();
        employee.setLogin(login);
        employee.setPassword(DigestUtils.md5Hex(login));
        employee.setName(training.getExternalTrainerName());
        employee.setPhone(training.getExternalTrainerPhone());
        employee.setMail(training.getExternalTrainerMail());
        return employee;
    }

}
