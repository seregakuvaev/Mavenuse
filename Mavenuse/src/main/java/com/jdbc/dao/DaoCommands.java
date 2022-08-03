package com.jdbc.dao;

import com.jdbc.model.User;
import com.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
//не создавать везде новые объекты Утил, зачем так делать
//добавить метод, который будет очищать таблицу
//добавить метод, который будет закрывать соединение
//реализовать один коннекшн на всю программу и не плодить новые Утил
public class DaoCommands implements Dao {
    //поле с объектом утил
    @Override
    public void add(String name) {
        try (Connection connection = new Util().connection) {
            connection.setAutoCommit(false);
            try {
                String add = "INSERT INTO users (name) VALUE (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(add);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void delete(String name) {
        try (Connection connection = new Util().connection) {
            connection.setAutoCommit(false);
            try {
                String delete = "DELETE FROM users WHERE name =?;";
                PreparedStatement preparedStatement = connection.prepareStatement(delete);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                connection.rollback();
                connection.setAutoCommit(true);
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTable() {
        try (Connection connection = new Util().connection) {
            connection.setAutoCommit(false);
            try {
                String createTable = "CREATE TABLE IF NOT EXISTS users( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL)";
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "CREATE TABLE IF NOT EXISTS users( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL)");
                preparedStatement.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<User> getResult() {
        try (Connection connection = new Util().connection) {
            connection.setAutoCommit(false);
            try {
                ArrayList<User> users = new ArrayList<>();
                String getResult = "select * from users";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(getResult);
                connection.commit();
                connection.setAutoCommit(true);
                while (resultSet.next()) {
                    users.add(new User(resultSet.getString("name")));
                }
                return users;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                connection.rollback();
                connection.setAutoCommit(true);
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteTable() {
        try (Connection connection = new Util().connection) {
            connection.setAutoCommit(false);
            try {
                String deleteTable = "DROP TABLE IF EXISTS users";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteTable);
                preparedStatement.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
