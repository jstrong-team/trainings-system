package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.controller.impl.EmployeeControllerImpl;
import com.exadel.jstrong.web.fortrainings.controller.impl.TrainingsControllerImpl;

public class Controller {
    private EmployeeController eci;
    private TrainingsController tci;

    public Controller() {
        eci = new EmployeeControllerImpl();
        tci = new TrainingsControllerImpl();
    }
}
