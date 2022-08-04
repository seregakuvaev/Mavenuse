package com.jdbc.dao;

import com.jdbc.model.User;
import com.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;

public class DaoImpl implements Dao {

    Connection connection = new Util().getCon();


    @Override
    public void add(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (name) VALUE (?)");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE name =?;");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS users( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL)");
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getResult() {
        try (Statement statement = connection.createStatement()) {
            ArrayList<User> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(
                    "select * from users");
            connection.commit();
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("name")));
            }
            return users;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteTable() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DROP TABLE IF EXISTS users");
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override  //это делается одной скл командой вообще то
    public void clearTable() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "TRUNCATE users");
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
