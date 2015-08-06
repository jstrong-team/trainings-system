package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.*;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Report;
import com.exadel.jstrong.fortrainings.core.model.TrainerFeedback;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.ReportController;
import com.exadel.jstrong.web.fortrainings.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anton on 05.08.2015.
 */
@Component
public class ReportControllerImpl implements ReportController {

    @Autowired
    private TrainingDAO trainingDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private SubscribeDAO subscribeDAO;
    @Autowired
    private ReportDAO reportDAO;
    @Autowired
    private TrainerFeedbackDAO trainerFeedbackDAO;

    @Override
    public ReportUI getReport(Integer userId, Integer trainingId, Date dateFrom, Date dateTo) {
        ReportUI report = new ReportUI();
        List<TrainingReportUI> reportTrainings;
        if (userId != null && !employeeDAO.isSubscriber(userId)){
            report.setTrainings(new ArrayList<TrainingReportUI>());
            return report;
        }
        List<Training> trainings = new ArrayList();
        if (trainingId != null){
            trainings.add(trainingDAO.getTrainingById(trainingId));
        } else {
            if (userId != null){
                trainings = trainingDAO.getTrainingsByUser(userId);
            } else {
                trainings = trainingDAO.getApprovedTrainings();
            }
        }
        reportTrainings = getReportTrainings(trainings);
        List<Employee> users = new ArrayList<>();
        List<UserReportUI> usersReports;
        for (TrainingReportUI t: reportTrainings){
            if (userId != null){
                users.add(employeeDAO.getEmployee(userId));
            } else {
                users = subscribeDAO.getSubscribersAsEmployees(t.getId());
            }
            usersReports = new ArrayList<>();
            for (Employee e: users){
                usersReports.add(getUserReport(e, t, dateFrom, dateTo));
            }
            t.setUsers(usersReports);
        }
        report.setTrainings(reportTrainings);
        return report;
    }

    @Override
    public ReportUI getReportFile(Integer userId, Integer trainingId, Date dateFrom, Date dateTo) {
        return null;
    }

    private List<TrainingReportUI> getReportTrainings (List<Training> trainings){
        List<TrainingReportUI> reportTrainings = new ArrayList<>();
        TrainingReportUI reportTraining;
        for (Training t: trainings){
            reportTraining = new TrainingReportUI();
            reportTraining.setId(t.getId());
            reportTraining.setName(t.getName());
            reportTrainings.add(reportTraining);
        }
        return reportTrainings;
    }

    private List<MeetReportUI> getReportMeets (List<Report> reports){
        List<MeetReportUI> meets = new ArrayList<>();
        MeetReportUI meet;
        for (Report r : reports){
            meet = new MeetReportUI();
            meet.setDate(r.getDate());
            meet.setAbsent(r.isAbsent());
            meet.setReason(r.getReason());
            meets.add(meet);
        }
        return meets;
    }

    private List<FeedbackReportUI> getReportFeedbacks (List<TrainerFeedback> feedbacks){
        List<FeedbackReportUI> reportFeedbacks = new ArrayList<>();
        FeedbackReportUI reportFeedback;
        for (TrainerFeedback f : feedbacks){
            reportFeedback = new FeedbackReportUI();
            reportFeedback.setDate(f.getAddDate());
            reportFeedback.setText(getFeedbackText(f));
            reportFeedbacks.add(reportFeedback);
        }
        return reportFeedbacks;
    }

    private UserReportUI getUserReport(Employee employee, TrainingReportUI training, Date dateFrom, Date dateTo){
        UserReportUI userReport = new UserReportUI();
        userReport.setName(employee.getName());
        userReport.setTrainingId(training.getId());
        userReport.setTrainingName(training.getName());

        List<Report> dbReports = reportDAO.getReportForEmployee(employee.getId(), training.getId(), dateFrom, dateTo);
        userReport.setMeets(getReportMeets(dbReports));

        List<TrainerFeedback> feedbacks = trainerFeedbackDAO.getTrainingFeedbacks(employee.getId(), training.getId());
        List<TrainerFeedback> positiveFeedbacks = new ArrayList<>();
        List<TrainerFeedback> negativeFeedbacks = new ArrayList<>();
        for (TrainerFeedback f: feedbacks){
            if (f.getRating() <= 2){
                positiveFeedbacks.add(f);
            } else {
                negativeFeedbacks.add(f);
            }
        }
        userReport.setPositiveFeedbacks(getReportFeedbacks(positiveFeedbacks));
        userReport.setNegativeFeedbacks(getReportFeedbacks(negativeFeedbacks));

        return userReport;
    }

    private String getFeedbackText(TrainerFeedback feedback){
        StringBuilder text = new StringBuilder("coming soon");
        return text.toString();
    }

}
