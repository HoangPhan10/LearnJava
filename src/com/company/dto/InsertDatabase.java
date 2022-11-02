package com.company.dto;

import com.company.connectionJDBC.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertDatabase {
    public static final Connection connection = ConnectionJDBC.getConnectionJDBC();
    public static  void insertRecord(int id,String name){
        String sql = "INSERT INTO Person(ID,Name) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.executeUpdate();
            System.out.println("Insert success person("+id+","+name+")");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }

}
