package com.javaweb.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutill {
    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mySQL://localhost:3306/aparterment";
            String username = "root";
            String password = "123456";
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }
}


