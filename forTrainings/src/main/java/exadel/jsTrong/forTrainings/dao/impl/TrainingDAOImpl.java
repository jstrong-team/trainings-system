package exadel.jsTrong.forTrainings.dao.impl;

import exadel.jsTrong.forTrainings.dao.TrainingDAO;
import exadel.jsTrong.forTrainings.db.ConnectionManager;
import exadel.jsTrong.forTrainings.model.Training;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl extends ConnectionManager implements TrainingDAO {

    @Override
    public Training getByID(String ID) {
        Training training = null;
        ResultSet rs = executeQuery("SELECT * FROM tranings WHERE id = " + ID);

        try {
            training = new Training(rs.getString("id"), rs.getString("name"),
                    rs.getString("date"), rs.getString("place"),
                    rs.getString("teacherName"), rs.getString("description"),
                    rs.getString("targetAudience"), rs.getBoolean("isInternal"), rs.getBoolean("isPaid"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return training;
    }

    @Override
    public Training update(Training training) {
        Training tr = null;

        // TODO

        return tr;
    }

    @Override
    public boolean save(Training training) {
        boolean res = false;

        // TODO

        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;

        // TODO

        return res;
    }

    @Override
    public List<Training> getAll() {
        List<Training> list = new ArrayList<>();

        // TODO

        return list;
    }

    @Override
    public List<Training> getTrainingsByName(String name) {
        List<Training> list = new ArrayList<>();
        Training training = null;
        String ID;

        ResultSet rs = executeQuery("SELECT id FROM tranings WHERE name = " + name);

        try {
            while (rs.next()) {
                ID = rs.getString("id");
                training = getByID(ID);
                list.add(training);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}