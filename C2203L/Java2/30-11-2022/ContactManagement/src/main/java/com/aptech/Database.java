package com.aptech;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3311/testdb";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Abc123456789";
    //disable default constructor
    private Database() {}
    private static Database instance;
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    CONNECTION_STRING,USER_NAME,PASSWORD);
        }catch(Exception e){
            System.err.println("Cannot connect db");
            e.printStackTrace();
            return null;
        }
    }
}
