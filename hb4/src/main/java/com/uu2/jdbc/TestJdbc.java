package com.uu2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user="hbstudent";
        String pass="hbstudent";
        try{
            System.out.println("Connecting to db: "+jdbcUrl);
            Connection myconn= DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection successful");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
