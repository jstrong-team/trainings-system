package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.EmployeeFeedbackDAO;
import com.exadel.jstrong.fortrainings.core.dao.MeetDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.model.EmployeeFeedback;
import com.exadel.jstrong.fortrainings.core.model.Meet;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import com.exadel.jstrong.fortrainings.core.model.Training;
import com.exadel.jstrong.fortrainings.core.model.enums.SubscribeStatus;
import com.exadel.jstrong.web.fortrainings.controller.TrainingStorageController;
import com.exadel.jstrong.web.fortrainings.model.EmployeeFeedbackUI;
import com.exadel.jstrong.web.fortrainings.model.SubscriberUI;
import com.exadel.jstrong.web.fortrainings.model.TrainingUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TrainingStorageControllerImpl implements TrainingStorageController {

    @Autowired
    private TrainingDAO tDAO;
    @Autowired
    private MeetDAO mDAO;
    @Autowired
    private SubscribeDAO sDAO;
    @Autowired
    private EmployeeFeedbackDAO emDAO;

    @Override
    public void addTraining(Training training) {
        int id = tDAO.add(training);
        List<String> dates = training.getDate();
        int size = dates.size();
        Meet meet = new Meet();
        for (int i = 0; i<size;i++){
            meet.setTraining_id(id);
            meet.setDate(dates.get(i));
            mDAO.add(meet);
        }
    }

    @Override
    public TrainingUI getTraining(int tId, int uId) {
        List<Meet> meets = mDAO.getMeetsByTrainingId(tId);
        int size = meets.size();
        List<String> dates = new ArrayList<String>(size);
        String date = "";
        for (int i = 0; i < size; i++){
            //date = date.concat(meets.get(i).getDate());
            dates.add(date.substring(0, date.indexOf('.')));
            date = "";
        }
        Training training = tDAO.getTrainingById(tId);
        training.setDate(dates);
        training.setIsSubscribe(tDAO.isSubscribeById(tId, uId));

        TrainingUI trainingUI = new TrainingUI(training.getId(), training.getName(), training.getAnnotation(),
                training.getDescription(), training.getTarget(), training.isPaid(), training.getMax_participants(),
                training.getPlace(), training.isInternal(), training.isApprove(), training.getTrainer_id(),
                training.getDate(), training.isSubscribe());
        int rate = tDAO.getRate(training);
        trainingUI.setRate(rate);
        return trainingUI;
    }

    @Override
    public boolean isTrainer(int uId, int tId) {
        return tDAO.isTrainer(uId, tId);
    }

    @Override
    public int addSubscriber(Subscribe s) {
        return sDAO.addSubscribe(s);
    }

    @Override
    public Subscribe buildSubscriber(int uId, int tId) {
        Subscribe s = new Subscribe();
        s.setEmployeeId(uId);
        s.setTrainingId(tId);

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        s.setAddDate(dateFormat.format(date));

        if(tDAO.isApprove(tId)) {
            s.setStatus(SubscribeStatus.APPROVE);
        } else {
            s.setStatus(SubscribeStatus.WAIT);
        }
        return s;
    }

    @Override
    public boolean check(int uId, int tId) {
        return (mDAO.isGoing(tId) && tDAO.isSubscribeById(uId, tId));
    }

    @Override
    public void addEmployeeFeedback(EmployeeFeedback ef) {
        emDAO.addFeedback(ef);
    }

    @Override
    public List<EmployeeFeedbackUI> getEmployeeFeedback(int tId) {
        List<EmployeeFeedback> employeeFeedbacks = emDAO.getAllFeedbacks(tId);
        List<EmployeeFeedbackUI> employeeFeedbackUIs = new ArrayList<EmployeeFeedbackUI>();
        for(EmployeeFeedback ef :employeeFeedbacks) {
            EmployeeFeedbackUI efUI = new EmployeeFeedbackUI(ef.getId(),ef.getEmployeeId(),ef.getTrainingId(),ef.getAddDate(),ef.isUnderstand(),ef.isInterested(),ef.isContinueWithThisTrainer(),ef.isSmthNew(),ef.isRecommend(),ef.getRate(),ef.getOther());
            employeeFeedbackUIs.add(efUI);
        }
        return employeeFeedbackUIs;
    }

    @Override
    public List<SubscriberUI> getSubscribers(int tId) {
        /*Training training = tDAO.getTrainingById(tId);
        List<SubscriberUI> subscriberUIs = new ArrayList<>();
        SubscriberUI subscriberUI = new SubscriberUI();
        Employee employee = null;
        List<Subscribe> subscribes = training.getSubscribes();
        for(Subscribe s: subscribes) {
            employee = s.getEmployee();
            subscriberUI.setId(employee.getId());
            subscriberUI.setName(employee.getName());
            subscriberUI.setStatus(s.getStatus());
            subscriberUIs.add(subscriberUI);
        }
        return subscriberUIs;*/
        return null;
    }



}
