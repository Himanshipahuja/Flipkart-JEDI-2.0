package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

//    private static Connection singleInstance = null;
    public static Connection connect() throws SQLException
     {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/flipfit-schema";
<<<<<<< HEAD
            Connection connection = DriverManager.getConnection(url,"root","avnihere1234");
=======
            Connection connection = DriverManager.getConnection(url,"root","Ridhhi@2001");
>>>>>>> 2f16e16 (added gym owner approval for admin)
                System.out.println("Database Connected");

            return connection;
        } catch (Exception e) {
            System.out.println("Could not connect to DB: " + e.getMessage());
            return null;
        }
    }
}
