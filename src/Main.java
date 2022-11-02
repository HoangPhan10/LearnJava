import com.company.connectionJDBC.ConnectionJDBC;

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
        insertTable(5,"Nguyen Chi Quang");
    }

    public static void selectTable() {
        try {
            String sql = "SELECT * from lop WHERE ID = 2";
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
        String sql = "INSERT INTO lop(ID,Name) values(2,'Quang')";
        try {
           int rs = statement.executeUpdate(sql);
           logger.log(Level.INFO,String.valueOf(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}