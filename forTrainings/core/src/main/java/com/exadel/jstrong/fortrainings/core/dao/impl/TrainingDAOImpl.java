package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.db.ConnectionManager;
import com.exadel.jstrong.fortrainings.core.model.Training;
import org.apache.log4j.Logger;
import java.sql.SQLException;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl implements TrainingDAO {
    private static Logger logger = Logger.getLogger(TrainingDAOImpl.class.getName());

    @Override
    public List<Training> getUserTrainingsLast3Month (int userId, String dateFrom, String dateTo, boolean isUser) {
        List<Training> list = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Training training = null;

        String sign = null;

        if (isUser) {
            sign = "=";
        } else {
            sign = "<>";
        }

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT training.id, training.name, training.annotation, meet.date FROM training, subscribe, meet where subscribe.employee_id "
                            + sign + userId + " and subscribe.status = 'approve' and  training.id = subscribe.training_id and meet.training_id = training.id and meet.date between ' "
                            + dateFrom + "' and '" + dateTo + "' order by meet.date;");
            while (resultSet.next()) {
                String buf = resultSet.getString("date");
                training = new Training(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("annotation"),
                        buf.substring(0, buf.length() - 2), false);
                list.add(training);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
        return list;
    }

    @Override
    public List<Training> getSearchResponse(String st) {
        List<Training> list = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Training training = null;

        try {
            connection = ConnectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT training.id, training.name, training.annotation, training.description, meet.date from  training join meet on meet.training_id = training.id where training.name like '%" + st + "%' or training.annotation like '%" + st + "%' or training.description like '%" + st + "%' order by meet.date");
            while (resultSet.next()) {
                String buf = resultSet.getString("date");
                training = new Training(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("annotation"),
                        buf.substring(0, buf.length() - 2), false);
                list.add(training);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
        }
        return list;
    }
}