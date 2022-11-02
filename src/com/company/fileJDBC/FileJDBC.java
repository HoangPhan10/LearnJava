package com.company.fileJDBC;

import com.company.connectionJDBC.ConnectionJDBC;

import java.io.*;
import java.sql.*;

public class FileJDBC {
    public static void main(String[] args) throws IOException, SQLException {
//        readFile();
    writeFile();
    }


    public static  void readFile() throws FileNotFoundException, SQLException {
        Connection connection = ConnectionJDBC.getConnectionJDBC();
        File file = new File("test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        String sql = "INSERT INTO File(name,file) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        preparedStatement.setBlob(2,fileInputStream);
        preparedStatement.executeUpdate();
        System.out.println("Thanh Cong");
    }
    public static void writeFile() throws SQLException, IOException {
        Connection connection = ConnectionJDBC.getConnectionJDBC();
        String sql = "SELECT * FROM File";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int name = resultSet.getInt("name");
            Blob file = resultSet.getBlob("file");
            byte[] b = file.getBytes(1,(int) file.length());
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(name));
            fileOutputStream.write(b);
            fileOutputStream.close();
        }
        System.out.println("Write success");
    }
}
