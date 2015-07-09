package exadel.jsTrong.forTrainings.dao.impl;

import exadel.jsTrong.forTrainings.dao.TrainingDAO;
import exadel.jsTrong.forTrainings.db.ConnectionManager;
import exadel.jsTrong.forTrainings.model.Training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl extends ConnectionManager implements TrainingDAO {

    @Override
    public Training getByID(String ID) {
        Training training = null;
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
        
        PreparedStatement ps = null;
        Connection connection = null;
        boolean boolRes = false;
        int res = 0;
        String sql = "UPDATE trainings SET name = ?, date = ?, place = ?, teacherName = ?, " +
                "description = ?,  audience = ?, isInternal = ?, isPaid = ?" +
                "WHERE id =" +training.getId();

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

        PreparedStatement ps = null;
        Connection connection = null;
        boolean boolRes = false;
        int res = 0;
        String sql = "INSERT INTO trainings (name,date,place,teacher,description,audience,isInternal,isPaid) " +
                "VALUES (?,?,?,?,?,?,?,?)";

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
        String ID;

        ResultSet rs = executeQuery("SELECT * FROM trainings");

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
    public List<Training> getTrainingsByName(String name) {
        List<Training> list = new ArrayList<>();
        Training training = null;

        ResultSet rs = executeQuery("SELECT * FROM trainings WHERE name = " + name);

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
}