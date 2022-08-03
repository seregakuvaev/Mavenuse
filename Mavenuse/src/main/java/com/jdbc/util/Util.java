package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//доступ к полю через геттеры сеттеры и сделать приватным
//вынести в поля строки для доступа к бд
public class Util {

    public Connection connection;

    public Util() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/daun", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
