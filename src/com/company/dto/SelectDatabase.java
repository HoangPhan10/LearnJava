package com.company.dto;

import com.company.connectionJDBC.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDatabase {
    public static final Connection connection = ConnectionJDBC.getConnectionJDBC();
    public static void selectRecordId(int id){
        if(id!=0){
            String sql = "Select * from Person where ID = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()==false){
                    System.out.println("Not found id = "+id);
                }

                while(resultSet.next()){
                    System.out.println(resultSet.getInt("ID")+" "+resultSet.getString("Name"));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            String sql = "Select * from Person";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()==false){
                    System.out.println("Table no data");
                }
                while(resultSet.next()){
                    System.out.println("ID"+ " "+resultSet.getInt("ID")+" ,Name: "+resultSet.getString("Name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
