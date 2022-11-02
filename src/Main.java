import com.company.connectionJDBC.ConnectionJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public final static Statement statement;
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    static {
        try {
            statement = ConnectionJDBC.getConnectionJDBC().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        insertTable(5,"Nguyen Chi Quang");
        updateTable(5,"Phan van Hoang");
//        selectTable();
          }


    public static void updateTable(int id,String name){
        String sql = "update lop set name = ? where ID = ? ";

        try {

            PreparedStatement preparedStatement = ConnectionJDBC.getConnectionJDBC().prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            int rs = preparedStatement.executeUpdate();
            logger.log(Level.INFO,String.valueOf(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void selectTable() {
        try {
            String sql = "SELECT * from lop";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                logger.log( Level.INFO,id + " " + name);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertTable(int id,String name){
        String sql = "INSERT INTO lop(ID,Name) values("+id+",'"+name+"')";
        try {
           int rs = statement.executeUpdate(sql);
           logger.log(Level.INFO,String.valueOf(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteTable(int id) {
        String sql ="DELETE from lop where ID = "+id;
        try {
            int rs = statement.executeUpdate(sql);
            logger.log(Level.INFO,String.valueOf(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}