package org.bookmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Database {
    private Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost:3310/c2109l";//connection string
    static final String USER = "root";
    static final String PASSWORD = "";
    public Connection getConnection() throws Exception{
        try {
            if(connection == null) {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } else {
                if(connection.isClosed()) {
                    connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                }
            }
            System.out.println("Connect to db successfully");
            return connection;
        } catch (Exception exception) {
            connection = null;
            System.err.println("Cannot connect DB, error: "+exception.getMessage());
            throw new Exception("Cannot connect DB, error: "+exception.getMessage());
        }
    }
    public void insertBook(String code, String name, int categoryId, float price) throws Exception{
        try {
            String sql = "INSERT INTO Book(code, bookName, price, categoryId) VALUES(?, ?, ?, ?);";
            PreparedStatement statement = this.getConnection()
                    .prepareStatement(sql);
            //prevent SQL injection
            statement.setString(1, code);
            statement.setString(2, name);
            statement.setInt(3, categoryId);
            statement.setFloat(4, price);
            statement.executeUpdate();
        } catch (Exception exception) {
            //throw new Exception(exception.getMessage()); //NO !
            throw new Exception("Cannot insert, please do later");//YES
        }
    }
}
/*
USE c2109l;
CREATE TABLE Category(
    categoryId INT PRIMARY KEY AUTO_INCREMENT,
    categoryName VARCHAR(200) NOT NULL
);
CREATE TABLE Book(
    code VARCHAR(20) PRIMARY KEY,
    bookName VARCHAR(200) NOT NULL,
    price FLOAT,
    categoryId INT
);
INSERT INTO Book(code, bookName, price, categoryId) VALUES("java11", "prgo nmnds java", 123.4, 1);

ALTER TABLE Book DROP CONSTRAINT FK_CategoryBook;

ALTER TABLE Book
ADD CONSTRAINT FK_CategoryBook
FOREIGN KEY (categoryId) REFERENCES Category(categoryId);

* */