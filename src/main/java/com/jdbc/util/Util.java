package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private Connection connection;

    public Util() {
        try {
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/daun";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon(){
        return connection;
    }
}
