package com.company.dto;

import com.company.connectionJDBC.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DeleteDatabase {
    public static final Connection connection = ConnectionJDBC.getConnectionJDBC();
    public static  void deleteById(int id){
        String sql = "Delete from Person where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Delete success id = "+id);
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }
    public static  void deleteByName(String name){
        String sql = "Delete from Person where name like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
            System.out.println("Delete success name = "+name);
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }
}
