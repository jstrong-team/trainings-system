package com.exadel.jstrong.fortrainings.web.controller;

import com.exadel.jstrong.fortrainings.web.controller.impl.EmployeeControllerImpl;
import com.exadel.jstrong.fortrainings.web.controller.impl.TrainingsControllerImpl;

public class Controller {
    private EmployeeController eci;
    private TrainingsController tci;

    public Controller() {
        eci = new EmployeeControllerImpl();
        tci = new TrainingsControllerImpl();
    }
}
