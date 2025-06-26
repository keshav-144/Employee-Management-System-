package EmployeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Keshav@2457");
            statement = connection.createStatement();
            //System.out.print("connected");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new conn();
    }
}
