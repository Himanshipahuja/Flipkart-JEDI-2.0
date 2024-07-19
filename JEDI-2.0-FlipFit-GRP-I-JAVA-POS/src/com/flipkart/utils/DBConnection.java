package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

//    private static Connection singleInstance = null;
    public static Connection connect() throws SQLException
     {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/flipfit-schema";
            Connection connection = DriverManager.getConnection(url,"root","29@Himanshi");
                System.out.println("Database Connected");

            return connection;
//            PreparedStatement stmt=connection.prepareStatement("insert into role values(?,?,?)");
//            stmt.setString(1,"sampleRoleId"); //1 specifies the first parameter in the query
//            stmt.setString(2,"sampleRole");
//            stmt.setString(3,"sampleRoleDesc");
//
//            int i=stmt.executeUpdate();
//            System.out.println(i+" records inserted");

        }
        catch (Exception e) {
            System.out.println("Could not connect to DB: " + e.getMessage() + " " + e);
            return null;
        }
    }
}
