package com.exadel.jstrong.web.fortrainings.restcontroller;

import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Participant;
import com.exadel.jstrong.fortrainings.core.model.TrainerFeedback;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.ReportController;
import com.exadel.jstrong.web.fortrainings.controller.TrainingStorageController;
import com.exadel.jstrong.web.fortrainings.model.*;
import com.exadel.jstrong.web.fortrainings.services.RestService;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/storagetraining")
public class TrainingStorageSpringController {

    private final String APPROVE = "approve";
    private final String CANCEL = "cansel";

    @Autowired
    private TrainingStorageController tsci;

    @Autowired
    private EmployeeController ec;

    @Autowired
    private ReportController reportController;

    @Autowired
    private RestService restService;

    private static Logger logger = Logger.getLogger(TrainingStorageSpringController.class);

    @RequestMapping(method = RequestMethod.POST)
    public void addTraining(@RequestBody Training training, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (training.getExternalTrainerName() == null) {
                int id = restService.getUserId(request);
                training.setTrainer_id(id);
            }
            training.setApprove(false);
            tsci.addTraining(training);
        } catch (Exception e) {
            logger.warn(e.toString());
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    //TODO: add error logging
    @RequestMapping(value = "/getTraining", method = RequestMethod.GET)
    public
    @ResponseBody
    TrainingUI getTraining(HttpServletRequest request, HttpServletResponse response) {
        try {
            int tId = Integer.parseInt(request.getParameter("id"));
            int uId = restService.getUserId(request);
            TrainingUI trainingUI = tsci.getTraining(tId, uId);
            if (trainingUI.isApprove()) {
                return trainingUI;
            } else {
                if (ec.isAdmin(uId)) {
                    return trainingUI;
                } else {
                    response.setStatus(HttpServletResponse.SC_CONFLICT);
                }
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "/deleteTraining", method = RequestMethod.DELETE)
    public void deleteTraining(HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("trainingId"));
        int userId = restService.getUserId(request);
        if(tsci.isTrainer(userId, trainingId) || ec.isAdmin(userId)) {
            tsci.deleteTraining(trainingId);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    //TODO: add error logigng
    @RequestMapping(value = "/addsubscriber", method = RequestMethod.POST)
    public void addSubscriber(HttpServletRequest request, HttpServletResponse response) {
        try {
            int trainingId = Integer.parseInt(request.getParameter("id"));
            int userId = restService.getUserId(request);
            if (!tsci.isTrainer(userId, trainingId)) {
                if (tsci.addSubscriber(tsci.buildSubscriber(userId, trainingId)) == 0) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    //TODO: add error logging
    @RequestMapping(value = "/addemployeefeedback", method = RequestMethod.POST)
    public void addFeedback(@RequestBody EmployeeFeedback ef, HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("id"));
        int userId = restService.getUserId(request);
        ef.setEmployeeId(userId);
        ef.setTrainingId(trainingId);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ef.setAddDate(date);

        if (tsci.check(userId, ef.getTrainingId())) {
            tsci.addEmployeeFeedback(ef);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    //TODO: replace e.printStackTrace --> logger.warn/error
    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET)
    public
    @ResponseBody
    List<EmployeeNamedFeedbackUI> getFeedbacks(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userId = restService.getUserId(request);
            int trainingId = Integer.parseInt(request.getParameter("id"));
            return tsci.getEmployeeNamedFeedback(trainingId, ec.isAdmin(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getSubscribers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SubscriberUI> getSubscribers(HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("id"));
        int userId = restService.getUserId(request);
        return tsci.getSubscribers(userId, trainingId);
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public
    @ResponseBody
    RoleUI getRole(HttpServletRequest request, HttpServletResponse response) {
        int userId = restService.getUserId(request);
        int trainingId = Integer.parseInt(request.getParameter("id"));
        RoleUI role = new RoleUI();
        if (ec.isAdmin(userId)) {
            role.setRole("admin");
        } else if (tsci.isTrainer(userId, trainingId)) {
            role.setRole("trainer");
        } else {
            role.setRole("user");
        }
        return role;
    }

    @RequestMapping(value = "isAdmin", method = RequestMethod.GET)
    public
    @ResponseBody
    RoleUI getRoleAdmin(HttpServletRequest request, HttpServletResponse response) {
        int userId = restService.getUserId(request);
        RoleUI role = new RoleUI();
        if (ec.isAdmin(userId)) {
            role.setRole("admin");
        } else {
            role.setRole("");
        }
        return role;
    }


    @RequestMapping(value = "/removeSubscriber", method = RequestMethod.DELETE)
    public void removeSubscriber(HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("id"));
        int userId = restService.getUserId(request);
        if (!tsci.deleteSubscriber(userId, trainingId)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/deleteFeedback", method = RequestMethod.DELETE)
    public void deleteFeedback(HttpServletRequest request, HttpServletResponse response) {
        int feedbackId = Integer.parseInt(request.getParameter("id"));
        if (!tsci.deleteFeedback(feedbackId)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/editTraining", method = RequestMethod.PUT)
    public void editTraining(@RequestBody Training training, HttpServletRequest request, HttpServletResponse response) {
        int oldTrainingId = Integer.parseInt(request.getParameter("id"));
        int userId = restService.getUserId(request);
        tsci.editTraining(oldTrainingId, training, userId);
    }

    //FIXME
    @RequestMapping(value = "/approve", method = RequestMethod.PUT)
    public void adminRequest(@RequestBody ApproveUI approveUI, HttpServletRequest request, HttpServletResponse response) {
        if (ec.isAdmin(restService.getUserId(request))) {
            if (APPROVE.compareToIgnoreCase(approveUI.getAdminAnswer()) == 0) {
                tsci.approveTraining(approveUI.getTransactionId());
            } else {
                tsci.killTransaction(approveUI.getTransactionId());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getReport", method = RequestMethod.GET)
    public
    @ResponseBody
    ReportUI getReport(HttpServletRequest request, HttpServletResponse response) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Integer employeeId;
        try {
            employeeId = Integer.parseInt(request.getParameter("userId"));
        } catch (Exception e) {
            employeeId = null;
        }
        Integer trainingId;
        try {
            trainingId = Integer.parseInt(request.getParameter("trainingId"));
        } catch (Exception e) {
            trainingId = null;
        }
        Date dateFrom;
        try{
            dateFrom = formatter.parse(request.getParameter("dateFrom"));
        } catch (Exception e) {
            dateFrom = null;
        }
        Date dateTo;
        try{
            dateTo = formatter.parse(request.getParameter("dateTo"));
        } catch (Exception e) {
            dateTo = null;
        }
        int userId = restService.getUserId(request);
        if (ec.isAdmin(userId)) {
            return reportController.getReport(employeeId, trainingId, dateFrom, dateTo);
        }
        return null;
    }

    @RequestMapping(value = "/getReportFile", method = RequestMethod.GET)
    public void getReportFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Integer employeeId;
        try {
            employeeId = Integer.parseInt(request.getParameter("userId"));
        } catch (Exception e) {
            employeeId = null;
        }
        Integer trainingId;
        try {
            trainingId = Integer.parseInt(request.getParameter("trainingId"));
        } catch (Exception e) {
            trainingId = null;
        }
        Date dateFrom;
        try{
            dateFrom = formatter.parse(request.getParameter("dateFrom"));
        } catch (Exception e) {
            dateFrom = null;
        }
        Date dateTo;
        try{
            dateTo = formatter.parse(request.getParameter("dateTo"));
        } catch (Exception e) {
            dateTo = null;
        }
        HSSFWorkbook workbook = reportController.getReportFile(employeeId, trainingId, dateFrom, dateTo);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=report.xls");
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    @RequestMapping(value = "/updateAttendance", method = RequestMethod.POST)
    public void updateParticipant(@RequestBody ParticipantUI participant, HttpServletRequest request, HttpServletResponse response) {

        List<Participant> participants = participant.getParticipant();
        int size = participants.size();
        if (size != 0) {
            tsci.updateParticipants(participants);
        }
    }

    @RequestMapping(value = "/mergeTrainings", method = RequestMethod.GET)
    public
    @ResponseBody
    MergedTrainingUI getMerge(HttpServletRequest request, HttpServletResponse response) {
        int transactionId = Integer.parseInt(request.getParameter("id"));
        int userId = restService.getUserId(request);
        if (ec.isAdmin(userId)) {
            MergedTrainingUI mergedTrainingUI = tsci.mergeTraining(transactionId);
            if (mergedTrainingUI != null) {
                return mergedTrainingUI;
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return null;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

    @RequestMapping(value = "/addTrainerFeedback", method = RequestMethod.POST)
    public void addTrainerFeedback(@RequestBody TrainerFeedback tf, HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("trainingId"));
        int feedbackerId = restService.getUserId(request);
        tf.setFeedbackerId(feedbackerId);
        tf.setTrainingId(trainingId);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tf.setAddDate(date);
        int subscribeId = tf.getEmployeeId();
        tf.setEmployeeId(tsci.getEmployeeIdBySubscribe(subscribeId));
        if(tsci.isTrainer(feedbackerId, tf.getTrainingId()) || ec.isAdmin(feedbackerId)) {
            tsci.addTrainerFeedback(tf);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/addExternalUser", method = RequestMethod.POST)
    public void addExternalUser(@RequestBody ExternalUserUI externalUserUI, HttpServletRequest request, HttpServletResponse response) {
        int trainingId = Integer.parseInt(request.getParameter("trainingId"));
        int userId = restService.getUserId(request);
        if(ec.isAdmin(userId) || tsci.isTrainer(userId, trainingId)) {
            tsci.addExternalUser(externalUserUI, trainingId);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/approveNew", method = RequestMethod.PUT)
    public void approveNew(@RequestBody ApproveUI approveUI, HttpServletRequest request, HttpServletResponse response) {
        if (ec.isAdmin(restService.getUserId(request))) {
            if (APPROVE.compareToIgnoreCase(approveUI.getAdminAnswer()) == 0) {
                tsci.approveNewTraining(approveUI.getTrainingId());
            } else {
                tsci.deleteTraining(approveUI.getTrainingId());
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getNotApprovedTraining", method = RequestMethod.GET)
    public
    @ResponseBody
    TrainingUI getNotApprovedTraining(HttpServletRequest request, HttpServletResponse response) {
        try {
            int tId = Integer.parseInt(request.getParameter("id"));
            int uId = restService.getUserId(request);
            TrainingUI trainingUI = tsci.getTraining(tId, uId);
            if (!trainingUI.isApprove()) {
                if (ec.isAdmin(uId)) {
                    return trainingUI;
                } else {
                    response.setStatus(HttpServletResponse.SC_CONFLICT);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "isExternal", method = RequestMethod.GET)
    public
    @ResponseBody
    RoleUI getRoleExternal(HttpServletRequest request, HttpServletResponse response) {
        int userId = restService.getUserId(request);
        RoleUI role = new RoleUI();
        if (ec.isExternal(userId)) {
            role.setRole("external");
        } else {
            role.setRole("");
        }
        return role;
    }
}

