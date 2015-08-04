package com.exadel.jstrong.web.fortrainings.controller.impl;

import com.exadel.jstrong.fortrainings.core.dao.*;
import com.exadel.jstrong.fortrainings.core.model.*;
import com.exadel.jstrong.fortrainings.core.model.enums.SubscribeStatus;
import com.exadel.jstrong.fortrainings.core.util.Merger;
import com.exadel.jstrong.web.fortrainings.controller.TrainingStorageController;
import com.exadel.jstrong.web.fortrainings.model.*;
import com.exadel.jstrong.web.fortrainings.model.comparator.SubscriberUIComp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
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
    @Autowired
    private EmployeeDAO eDAO;
    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private ParticipantDAO participantDAO;

    @Override
    @Transactional
    public int addTraining(Training training) {
        int id = tDAO.add(training);
        List<Date> dates = training.getDate();
        int size = dates.size();
        List<Meet> meets = new ArrayList<>();
        Meet meet = null;
        for (int i = 0; i<size;i++){
            meet = new Meet();
            meet.setTraining_id(id);
            meet.setDate(dates.get(i));
            meets.add(meet);
        }
        training.setMeets(meets);
        return id;
    }

    @Override
    public TrainingUI getTraining(int tId, int uId) {
        List<Meet> meets = mDAO.getMeetsByTrainingId(tId);
        int size = meets.size();
        List<MeetUI> meetUIs = new ArrayList<>(size);
        MeetUI meetUI = null;
        for (int i = 0; i < size; i++){
            meetUI = new MeetUI();
            meetUI.setDate(meets.get(i).getDate());
            meetUI.setId(meets.get(i).getId());
            meetUIs.add(meetUI);
        }
        Training training = tDAO.getTrainingById(tId);
        training.setIsSubscribe(tDAO.isSubscribeById(uId, tId));

        String name = eDAO.getNameById(training.getTrainer_id());

        TrainingUI trainingUI = new TrainingUI(training.getId(), training.getName(), name, training.getAnnotation(),
                training.getDescription(), training.getTarget(), training.isPaid(), training.getMax_participants(),
                training.getPlace(), training.isInternal(), training.isApprove(), training.getTrainer_id(),
                meetUIs, training.isSubscribe());
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
        List<Integer> meetIds = tDAO.getMeetIdsByTrainingId(s.getTrainingId());
        List<Participant> participants = new ArrayList<>();
        String status = s.getStatus();
        int id = sDAO.addSubscribe(s);
        if(status.compareToIgnoreCase("approve") == 0) {
            for (Integer i : meetIds) {
                Participant p = new Participant();
                p.setSubscribeId(id);
                p.setMeetId(i);
                participants.add(p);
            }
            participantDAO.addParticipants(participants);
        }
        return id;
    }

    @Override
    public Subscribe buildSubscriber(int uId, int tId) {
        Subscribe s = new Subscribe();
        s.setEmployeeId(uId);
        s.setTrainingId(tId);

        Date date = new Date();
        s.setAddDate(date);

        if(tDAO.isApprove(tId)) {
            s.setStatus(SubscribeStatus.Approve.toString());
        } else {
            s.setStatus(SubscribeStatus.Wait.toString());
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

//    @Override
//    public List<EmployeeFeedbackUI> getEmployeeFeedback(int tId) {
//        List<EmployeeFeedback> employeeFeedbacks = emDAO.getAllFeedbacks(tId);
//        List<EmployeeFeedbackUI> employeeFeedbackUIs = new ArrayList<EmployeeFeedbackUI>();
//        for(EmployeeFeedback ef :employeeFeedbacks) {
//            EmployeeFeedbackUI efUI = new EmployeeFeedbackUI(ef.getId(),ef.getEmployeeId(),ef.getTrainingId(),ef.getAddDate(),ef.isUnderstand(),ef.isInterested(),ef.isContinueWithThisTrainer(),ef.isSmthNew(),ef.isRecommend(),ef.getRate(),ef.getOther(), ef.isDelete());
//            employeeFeedbackUIs.add(efUI);
//        }
//        return employeeFeedbackUIs;
//    }

    public List<EmployeeNamedFeedbackUI> getEmployeeNamedFeedback(int tId, boolean isAdmin) {
        List<EmployeeFeedback> employeeFeedbacks = emDAO.getAllFeedbacks(tId);
        List<EmployeeNamedFeedbackUI> employeeFeedbackUIs = new ArrayList<EmployeeNamedFeedbackUI>();
        for(EmployeeFeedback ef :employeeFeedbacks) {
            EmployeeNamedFeedbackUI efUI = null;
            if(isAdmin) {
                efUI = new EmployeeNamedFeedbackUI(ef.getId(), eDAO.getNameById(ef.getEmployeeId()), ef.getEmployeeId(), ef.getTrainingId(), ef.getAddDate(), ef.isUnderstand(), ef.isInterested(), ef.isContinueWithThisTrainer(), ef.isSmthNew(), ef.isRecommend(), ef.getRate(), ef.getOther(), ef.isDelete());
            } else {
                efUI = new EmployeeNamedFeedbackUI(ef.getId(), null, ef.getEmployeeId(), ef.getTrainingId(), ef.getAddDate(), ef.isUnderstand(), ef.isInterested(), ef.isContinueWithThisTrainer(), ef.isSmthNew(), ef.isRecommend(), ef.getRate(), ef.getOther(), ef.isDelete());
            }
            employeeFeedbackUIs.add(efUI);
        }
        return employeeFeedbackUIs;
    }

    @Override
    public List<SubscriberUI> getSubscribers(int uId, int tId) {
        List<Subscribe> subscribers = tDAO.getSubscribers(tId);
        List<SubscriberUI> subscribersUI = new ArrayList<>();
        List<Integer> meetIds = tDAO.getMeetIdsByTrainingId(tId);
        Collections.sort(meetIds);
        SubscriberUI subscriber = null;
        for (Subscribe s: subscribers){
            List<Participant> participants = sDAO.getParticipantsByMeetIds(s.getId(), meetIds);
            subscriber = new SubscriberUI(s.getId(), eDAO.getNameById(s.getEmployeeId()), s.getStatus(), s.getAddDate(), participants);
            if("deleted".compareToIgnoreCase(subscriber.getStatus()) == 0) {
                if(eDAO.isAdmin(uId)) {
                    subscribersUI.add(subscriber);
                }
            } else {
                subscribersUI.add(subscriber);
            }
        }
        Collections.sort(subscribersUI, new SubscriberUIComp());
        return subscribersUI;
    }

    @Override
    public boolean deleteFeedback(int id) {
        return emDAO.deleteFeedback(id);
    }

    @Override
    public boolean deleteSuscriber(int userId, int trainingId) {
        int id = sDAO.contains(userId, trainingId);
        List<Integer> meetIds = tDAO.getMeetIdsByTrainingId(trainingId);
        List<Participant> participants = sDAO.getParticipantsByMeetIds(id, meetIds);
        participantDAO.deleteParticipants(participants);

        int subscribeId = sDAO.getSubscribeIdToApprove(id);
        if(subscribeId != 0) {
            List<Participant> participantsToAdd = new ArrayList<>();
            for (Integer integer : meetIds) {
                Participant p = new Participant();
                p.setSubscribeId(subscribeId);
                p.setMeetId(integer);
                participantsToAdd.add(p);
            }
            participantDAO.addParticipants(participantsToAdd);
        }

        if(sDAO.removeSubscriber(userId, trainingId) && sDAO.changeStatusToApprove(trainingId)) {

            return true;
        } else {
            return false;
        }
    }

    //TODO
    @Override
    @Transactional
    public void editTraining(int oldTrainingId, Training training) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        training.setId(oldTrainingId);
        String json = gson.toJson(training);
        List<Transaction> meets = new ArrayList<>();

        Transaction transaction = new Transaction();
        transaction.setEntityName("training");
        transaction.setOldId(oldTrainingId);
        transaction.setJson(json);
        int id = transactionDAO.add(transaction);

        List<Date> dates = training.getDate();
        int size = dates.size();

        Meet meet = null;
        Transaction transactionMeet = null;

        for (int i = 0; i < size; i++) {
            meet = new Meet();
            transactionMeet = new Transaction();
            meet.setTraining_id(oldTrainingId);
            meet.setDate(dates.get(i));
            String jsonMeet = gson.toJson(meet);
            transactionMeet.setJson(jsonMeet);
            transactionMeet.setOldId(oldTrainingId);
            transactionMeet.setEntityName("meet");
            transactionMeet.setParentId(id);
            transactionDAO.add(transactionMeet);
        }
    }

    @Override
    @Transactional
    public int approveTraining(int transactionId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Transaction transaction = transactionDAO.getTransactionById(transactionId);
        int oldTrainingId = transaction.getOldId();
        Training data = gson.fromJson(transaction.getJson(), Training.class);
        int newMaxParticipant = data.getMax_participants();
        Hibernate.initialize(data);
        data.setApprove(true);
        mDAO.removeMeets(oldTrainingId);

        int id = tDAO.updateTraining(data);

        updateMeets(gson, transaction, id);

        int countApprove = sDAO.getApproveCount(oldTrainingId);
        if(countApprove > newMaxParticipant) {
            unsubscribeUsers(newMaxParticipant, id, countApprove);
        } else {
            subscribeUsers(newMaxParticipant, id, countApprove);
        }
        return id;
    }

    private void subscribeUsers(int newMaxParticipant, int id, int countApprove) {
        int count = newMaxParticipant - countApprove;
        for(int i = 0; i < count; ++i) {

            //TODO
            List<Integer> meetIds = tDAO.getMeetIdsByTrainingId(id);
            int subscribeId = sDAO.getSubscribeIdToApprove(id);
            if(subscribeId != 0) {
                List<Participant> participants = new ArrayList<>();
                for (Integer integer : meetIds) {
                    Participant p = new Participant();
                    p.setSubscribeId(subscribeId);
                    p.setMeetId(integer);
                    participants.add(p);
                }
                participantDAO.addParticipants(participants);
            }

            sDAO.changeStatusToApprove(id);
        }
    }

    private void unsubscribeUsers(int newMaxParticipant, int id, int countApprove) {
        int count = countApprove - newMaxParticipant;

        List<Integer> meetIds = tDAO.getMeetIdsByTrainingId(id);

        for(int i = 0; i < count; ++i) {

            int subscribeId = sDAO.getSubscribeIdToWait(id);
            //TODO
            if(subscribeId != 0) {
                List<Participant> participants = sDAO.getParticipantsByMeetIds(subscribeId, meetIds);
                participantDAO.deleteParticipants(participants);
            }

            sDAO.changeStatusToWait(id);
        }
    }

    private void updateMeets(Gson gson, Transaction transaction, int id) {
        List<Transaction> meets = transactionDAO.getTransactionsByParent(transaction.getId());
        int size = meets.size();
        Meet meet = null;
        for(int i = 0; i < size; ++i) {
            meet = gson.fromJson(meets.get(i).getJson(), Meet.class);
            meet.setTraining_id(id);
            mDAO.add(meet);
        }
    }

    @Override
    public List<MeetReportUI> getMeetReportUIs(int employeeId) {
        List<Subscribe> subscribes = sDAO.getSubscribersByEmployeeId(employeeId);
        List<MeetReportUI> meetReportUIs = new ArrayList<>();

        MeetReportUI meetReportUI = null;
        for(Subscribe s :subscribes) {
            int trainingId = s.getTrainingId();
            List<Participant> participants = tDAO.getAllBySubscribeId(s.getId());
            for (Participant p : participants) {
                meetReportUI = new MeetReportUI();
                meetReportUI.setAbsent(p.isAbsent());
                //meetReportUI.setDate(p.getDate());
                meetReportUI.setReason(p.getReason());
                meetReportUI.setTrainingName(tDAO.getTrainingName(trainingId));
                meetReportUIs.add(meetReportUI);
            }
        }
        return meetReportUIs;
    }

    @Override
    public List<TrainingReportUI> getReportUI(int employeeId) {
        List<Subscribe> subscribes = sDAO.getSubscribersByEmployeeId(employeeId);
        List<TrainingReportUI> trainingReportUIs = new ArrayList<>();
        TrainingReportUI trainingReportUI = null;
        for(Subscribe s :subscribes) {
            trainingReportUI = new TrainingReportUI();
            trainingReportUI.setMeetReportUIs(getMeetReportUIs(s.getId()));
            int trainingId = s.getTrainingId();
            trainingReportUI.setTrainingName(tDAO.getTrainingName(trainingId));
            trainingReportUIs.add(trainingReportUI);
        }
        return trainingReportUIs;
    }

    @Override
    public void changeTrainingStatus(int trainingId) {
        tDAO.changeStatus(trainingId);
    }

    @Override
    public void killTransaction(int transactionId) {
        transactionDAO.killTransaction(transactionId);
    }

    @Override
    public void updateParticipants(List<Participant> participants) {
        for(Participant p: participants) {
            participantDAO.updateParticipant(p);
        }
    }

    @Override
    public MergedTrainingUI mergeTraining(int transactionID) {

        Training transactionTraining = tDAO.getTrainingByTransactionID(transactionID);
        Training training = tDAO.getTrainingById(transactionTraining.getId());

        MergedTrainingUI mergedTraining = new MergedTrainingUI();
        mergedTraining.setName(Merger.merge(training.getName(), transactionTraining.getName()));
        mergedTraining.setAnnotation(Merger.merge(training.getAnnotation(), transactionTraining.getAnnotation()));
        mergedTraining.setDescription(Merger.merge(training.getDescription(), transactionTraining.getDescription()));
        mergedTraining.setTarget(Merger.merge(training.getTarget(), transactionTraining.getTarget()));
        mergedTraining.setPlace(Merger.merge(training.getPlace(), transactionTraining.getPlace()));
        mergedTraining.setOldPaid(training.isPaid());
        mergedTraining.setNewPaid(transactionTraining.isPaid());
        mergedTraining.setOldMax_participants(training.getMax_participants());
        mergedTraining.setNewMax_participants(transactionTraining.getMax_participants());
        mergedTraining.setOldInternal(training.isInternal());
        mergedTraining.setNewInternal(transactionTraining.isInternal());
        List<Meet> meets = mDAO.getMeetsByTrainingId(training.getId());
        List<Date> dates = new ArrayList<>();
        for(Meet m: meets) {
            dates.add(m.getDate());
        }
        mergedTraining.setOldDates(dates);
        mergedTraining.setNewDates(transactionTraining.getDate());

        return mergedTraining;
    }

}
