package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect {

    private  static Connection conn = null;
    public static Connection getConn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12622167", "sql12622167", "MyeJc8AtaP");
        }

        catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

}
