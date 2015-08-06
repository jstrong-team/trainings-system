package com.exadel.jstrong.fortrainings.core.dao;

import com.exadel.jstrong.fortrainings.core.model.Report;

import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 06.08.2015.
 */
public interface ReportDAO {

    List<Report> getReportForEmployee (int userId, int trainingId, Date dateFrom, Date dateTo);

}
