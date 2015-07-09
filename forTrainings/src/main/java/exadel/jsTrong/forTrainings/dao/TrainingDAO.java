package exadel.jsTrong.forTrainings.dao;

import exadel.jsTrong.forTrainings.model.Training;

import java.util.List;

public interface TrainingDAO extends GenericDAO<Training> {

    List<Training> getTrainingsByName(String name);
    /*
    List<Training> getTrainingsByDate(String date);
    List<Training> getTrainingsByTeacher(String teacherName);
    List<Training> getTrainingsByDescription(String description);
    List<Training> getTrainingsByTargetAudience(String targetAudience);
    List<Training> getPaidTrainings();
    */
}
