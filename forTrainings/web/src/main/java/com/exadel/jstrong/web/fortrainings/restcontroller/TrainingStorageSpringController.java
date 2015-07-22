package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.fortrainings.core.model.TrainingToAdd;
import com.exadel.jstrong.fortrainings.core.model.TrainingToGet;
import com.exadel.jstrong.web.fortrainings.controller.impl.TrainingStorageControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Администратор on 21.07.2015.
 */
@RestController
@RequestMapping(value="/storagetraining")
public class TrainingStorageSpringController {

    @Autowired
    TrainingStorageControllerImpl tsci;

    @RequestMapping(method = RequestMethod.POST)
    public void addTraining(@RequestBody TrainingToAdd training, HttpServletResponse response) throws IOException {
        /*System.out.println(training.getName());
        List<String> dates = training.getDates();
        for(String s: dates) {
            System.out.println(s);*/
        try {

            tsci.addMeets(tsci.toMeets(training.getId(), training.getDates()));
            tsci.addTraining(training);

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody TrainingToGet getTraining (HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
