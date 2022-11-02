import com.company.connectionJDBC.ConnectionJDBC;
import com.company.dto.DeleteDatabase;
import com.company.dto.InsertDatabase;
import com.company.dto.SelectDatabase;
import com.company.dto.UpdateDatabase;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static final Scanner scanner = new Scanner(System.in);

    public static final Connection connection = ConnectionJDBC.getConnectionJDBC();
    public static void main(String[] args) {

        while(true){
            System.out.println("--------------- MENU ---------------");
            System.out.println("1.Select find data by id.");
            System.out.println("2.Select list data table");
            System.out.println("3.Insert data table(id,name)");
            System.out.println("4.Delete data by id or name");
            System.out.println("5.Update data by id");
            System.out.println("6.End");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.printf("Select find data by id :");
                    int id = scanner.nextInt();
                    SelectDatabase.selectRecordId(id);
                    int res = handle();
                    if(res==0){
                        return;
                    }
                    break;
                case 2:
                    System.out.println("Data table filter:");
                    SelectDatabase.selectRecordId(0);
                    int res2 = handle();
                    if(res2==0){
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Insert data table(id,name)");
                    System.out.printf("Enter id : ");
                    int id3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.printf("Enter name : ");
                    String name3 = scanner.nextLine();
                    InsertDatabase.insertRecord(id3,name3);
                    int res3 = handle();
                    if(res3==0){
                        return;
                    }
                    break;
                case 4:
                    System.out.println("Delete data (1-id,2-name)");
                    int del = scanner.nextInt();
                    scanner.nextLine();
                    if(del==1){
                        System.out.printf("Id = ");
                        int id4 = scanner.nextInt();
                        DeleteDatabase.deleteById(id4);
                    }else{
                        System.out.printf("Name = ");
                        String name4 = scanner.nextLine();
                        DeleteDatabase.deleteByName(name4);
                    }
                    int res4 = handle();
                    if(res4==0){
                        return;
                    }
                    break;
                case 5:
                    System.out.printf("Update data by id : ");
                    int id5 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.printf("Update id = "+id5+" name = ");
                    String name5 = scanner.nextLine();
                    UpdateDatabase.updateById(id5,name5);
                    int res5 = handle();
                    if(res5==0){
                        return;
                    }
                    break;

                default:
                    logger.log(Level.INFO,"The End Game");
                    return;
            }
        }
    }
    public static int handle(){
        System.out.println("Do you want to continue (1-Yes,0-No)?");
        int res = scanner.nextInt();
        if(res==0){
            logger.log(Level.INFO,"The End Game");
            return 0;
        }
        return 1;
    }
}