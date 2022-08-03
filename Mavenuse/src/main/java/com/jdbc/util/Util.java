package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public Connection connection;

    public Util() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
