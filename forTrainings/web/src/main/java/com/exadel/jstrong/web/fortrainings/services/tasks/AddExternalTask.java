package com.exadel.jstrong.web.fortrainings.services.tasks;

import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.web.fortrainings.services.mailservice.Sender;

/**
 * Created by Администратор on 07.08.2015.
 */
public class AddExternalTask implements Runnable {

    private Employee employee;

    public AddExternalTask(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
        int a;
        Sender.sendAccountData(employee);
    }
}
