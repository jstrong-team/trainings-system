package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.ReportDAO;
import com.exadel.jstrong.fortrainings.core.model.Report;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 06.08.2015.
 */
@Service
public class ReportDAOImpl extends BaseDAO<Report> implements ReportDAO {

    Logger logger = Logger.getLogger(ReportDAOImpl.class);

    @Override
    public List<Report> getReportForEmployee(int userId, int trainingId, Date dateFrom, Date dateTo) {
        try {
            if (dateFrom != null && dateTo != null) {
                return em.createNativeQuery("SELECT * FROM report WHERE subscribe_id IN (SELECT id FROM subscribe WHERE employee_id = :userId AND training_id = :trainingId)", Report.class).setParameter("userId", userId).setParameter("trainingId", trainingId).getResultList();
            }
            if (dateFrom != null) {
                return em.createNativeQuery("SELECT * FROM report WHERE subscribe_id IN (SELECT id FROM subscribe WHERE employee_id = :userId AND training_id = :trainingId) AND date > :dateFrom", Report.class).setParameter("userId", userId).setParameter("trainingId", trainingId).setParameter("dateFrom", dateFrom).getResultList();
            }
            if (dateTo != null) {
                return em.createNativeQuery("SELECT * FROM report WHERE subscribe_id IN (SELECT id FROM subscribe WHERE employee_id = :userId AND training_id = :trainingId) AND date < :dateTo", Report.class).setParameter("userId", userId).setParameter("trainingId", trainingId).setParameter("dateTo", dateTo).getResultList();
            }
            return em.createNativeQuery("SELECT * FROM report WHERE subscribe_id IN (SELECT id FROM subscribe WHERE employee_id = :userId AND training_id = :trainingId) AND date BETWEEN :dateFrom AND :dateTo", Report.class).setParameter("userId", userId).setParameter("trainingId", trainingId).setParameter("dateFrom", dateFrom).setParameter("dateTo", dateTo).getResultList();
        } catch (Throwable e) {
            logger.warn(e.toString());
            return new ArrayList<>();
        }
    }

}
