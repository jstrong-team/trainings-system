package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.controller.impl.EmployeeControllerImpl;
import com.exadel.jstrong.web.fortrainings.controller.impl.TrainingsControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
    @Autowired
    private EmployeeController eci;
    @Autowired
    private TrainingsController tci;
}
