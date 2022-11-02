package com.company.connectionJDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static Connection getConnectionJDBC(){
        final String url = "jdbc:mysql://localhost:3306/DataBases";
        final String user= "root";
        final String password = "111111";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
