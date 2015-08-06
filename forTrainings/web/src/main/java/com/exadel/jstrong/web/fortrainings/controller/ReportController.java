package com.exadel.jstrong.web.fortrainings.controller;

import com.exadel.jstrong.web.fortrainings.model.ReportUI;

import java.util.Date;

/**
 * Created by Anton on 05.08.2015.
 */
public interface ReportController {

    ReportUI getReport(Integer userId, Integer trainingId, Date dateFrom, Date dateTo);
    ReportUI getReportFile(Integer userId, Integer trainingId, Date dateFrom, Date dateTo);

}
