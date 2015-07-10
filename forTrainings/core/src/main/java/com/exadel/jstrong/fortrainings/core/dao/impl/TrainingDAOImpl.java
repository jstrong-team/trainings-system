package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.db.ConnectionManager;
import com.exadel.jstrong.fortrainings.core.model.Employee;
import com.exadel.jstrong.fortrainings.core.model.Training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl extends ConnectionManager implements TrainingDAO {

    @Override
    public Training getByID(String ID) {
        Training training = null;Connection connection = null;
        ResultSet rs = executeQuery("SELECT * FROM trainings WHERE id = " + ID);

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
    public boolean update(Training training) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean boolRes = false;
        int res = 0;
        String sql = "UPDATE trainings SET name = ?, date = ?, place = ?, teacherName = ?, " +
                "description = ?,  audience = ?, isInternal = ?, isPaid = ?" +
                "WHERE id = " + training.getId();

        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, training.getName());
            ps.setString(2, training.getDate());
            ps.setString(3, training.getPlace());
            ps.setString(4, training.getTeacherName());
            ps.setString(5, training.getDescription());
            ps.setString(6, training.getTargetAudience());
            ps.setBoolean(7, training.getInternal());
            ps.setBoolean(8, training.getPaid());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, ps, connection);
        }

        if (res > 0)
            boolRes = true;

        return boolRes;
    }

    @Override
    public boolean save(Training training) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean boolRes = false;
        int res = 0;
        String sql = "INSERT INTO trainings (name,date,place,teacher,description,audience,isInternal,isPaid) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);

            ps = connection.prepareStatement(sql);
            ps.setString(1, training.getName());
            ps.setString(2, training.getDate());
            ps.setString(3, training.getPlace());
            ps.setString(4, training.getTeacherName());
            ps.setString(5, training.getDescription());
            ps.setString(6, training.getTargetAudience());
            ps.setBoolean(7, training.getInternal());
            ps.setBoolean(8, training.getPaid());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, ps, connection);
        }

        if (res > 0)
            boolRes = true;

        return boolRes;
    }

    @Override
    public boolean delete(String id) {
        boolean boolRes = false;
        int res = executeUpdate("DELETE FROM trainings WHERE id = " + id);

        if (res > 0)
            boolRes = true;

        return boolRes;
    }

    @Override
    public List<Training> getAll() {
        List<Training> list = new ArrayList<>();
        Training training = null;

        ResultSet rs = executeQuery("SELECT * FROM trainings");

        try {
            while (rs.next()) {
                training = new Training(rs.getString("id"), rs.getString("name"),
                        rs.getString("date"), rs.getString("place"),
                        rs.getString("teacherName"), rs.getString("description"),
                        rs.getString("targetAudience"), rs.getBoolean("isInternal"), rs.getBoolean("isPaid"));
                list.add(training);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Training> getTrainingsByTrainer(Employee trainer) {
        Connection connection = null;
        PreparedStatement ps = null;
        List<Training> list = new ArrayList<>();
        ResultSet rs = null;
        Training training = null;

        String sql = "SELECT * FROM trainings WHERE trainer_id = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);

            ps.setString(1, trainer.getId());
            rs = ps.executeQuery();

            while (rs.next()) {
                training = new Training(rs.getString("id"), rs.getString("name"),
                        rs.getString("date"), rs.getString("place"),
                        rs.getString("teacherName"), rs.getString("description"),
                        rs.getString("targetAudience"), rs.getBoolean("isInternal"), rs.getBoolean("isPaid"));
                list.add(training);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, ps, connection);
        }

        return list;

    }

    @Override
    public List<Training> getTrainingsByField(String columnName, String columnValue) {
        List<Training> list = new ArrayList<>();
        Training training = null;

        ResultSet rs = executeQuery("SELECT * FROM trainings WHERE " + columnName + " = " + columnValue);

        try {
            while (rs.next()) {
                training = new Training(rs.getString("id"), rs.getString("name"),
                        rs.getString("date"), rs.getString("place"),
                        rs.getString("teacherName"), rs.getString("description"),
                        rs.getString("targetAudience"), rs.getBoolean("isInternal"), rs.getBoolean("isPaid"));
                list.add(training);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Training> getPaidTrainings() {
        List<Training> list = new ArrayList<>();
        Training training = null;

        ResultSet rs = executeQuery("SELECT * FROM trainings WHERE isPaid = 1");

        try {
            while (rs.next()) {
                training = new Training(rs.getString("id"), rs.getString("name"),
                        rs.getString("date"), rs.getString("place"),
                        rs.getString("teacherName"), rs.getString("description"),
                        rs.getString("targetAudience"), rs.getBoolean("isInternal"), rs.getBoolean("isPaid"));
                list.add(training);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    };
}