package com.company.dto;

import com.company.connectionJDBC.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDatabase {
    public static final Connection connection = ConnectionJDBC.getConnectionJDBC();
    public static void updateById(int id,String name){
        String sql = "Update Person set name = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            System.out.println("Update success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
