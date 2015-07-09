package exadel.jsTrong.forTrainings.dao;

import exadel.jsTrong.forTrainings.model.Employee;
import exadel.jsTrong.forTrainings.model.Training;

import java.util.List;

public interface TrainingDAO extends GenericDAO<Training> {

    List<Training> getTrainingsByTrainer(Employee trainer);
    List<Training> getTrainingsByField(String columnName, String columnValue);  // columnName = "name", "annotation"...
    List<Training> getPaidTrainings();
}
