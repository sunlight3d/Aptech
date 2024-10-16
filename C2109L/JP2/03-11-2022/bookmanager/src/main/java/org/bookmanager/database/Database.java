package org.bookmanager.database;

import org.bookmanager.models.Book;
import org.bookmanager.models.Category;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost:3306/c2109l";//connection string
    static final String USER = "root";
    static final String PASSWORD = "";
    public static String TABLE_CATEGORY = "Category";
    public static String TABLE_BOOK = "Book";
    private static Database instance;
    private Database() {

    }
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
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
    public ArrayList<Category> getCategories() throws Exception{
        ArrayList<Category> result = new ArrayList<Category>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+TABLE_CATEGORY);
            // Extract data from result set
            while (resultSet.next()) {
                // Fetch data to object
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCategoryName(resultSet.getString("categoryName"));
                result.add(category);
            }
            return result;
        } catch (Exception exception) {
            throw new Exception("cannot get data from DB");
        }
    }
    public ArrayList<Book> getBooks() throws Exception{
        ArrayList<Book> result = new ArrayList<Book>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+TABLE_BOOK);
            // Extract data from result set
            while (resultSet.next()) {
                // Fetch data to object
                Book book = new Book();
                book.setCode(resultSet.getString("code"));
                book.setBookName(resultSet.getString("bookName"));
                book.setPrice(resultSet.getFloat("price"));
                book.setCategoryId(resultSet.getInt("categoryId"));
                result.add(book);
            }
            return result;
        } catch (Exception exception) {
            throw new Exception("Cannot get books from DB");
        }
    }
    public void insertBook(String code, String name, int categoryId, float price) throws Exception{
        try {
            String sql = "INSERT INTO "+TABLE_BOOK+"(code, bookName, price, categoryId) VALUES(?, ?, ?, ?);";
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
    public void deleteBook(String code) throws Exception{
        try {
            String sql = "DELETE FROM "+TABLE_BOOK+" WHERE code =?;";
            PreparedStatement statement = this.getConnection()
                    .prepareStatement(sql);
            statement.setString(1, code);
            statement.executeUpdate();
        } catch (Exception exception) {
            //throw new Exception(exception.getMessage()); //NO !
            throw new Exception("Cannot delete, please do later");//YES
        }
    }
    public void updateBook(String code, Book book) throws Exception{
        try {
            String sql = "UPDATE "+TABLE_BOOK+" SET bookName=?, categoryId=?, price=? WHERE code = ?;";
            PreparedStatement statement = this.getConnection()
                    .prepareStatement(sql);
            //prevent SQL injection
            statement.setString(1, book.getBookName());
            statement.setInt(2, book.getCategoryId());
            statement.setFloat(3, book.getPrice());
            statement.setString(4, code);
            statement.executeUpdate();
        } catch (Exception exception) {
            //throw new Exception(exception.getMessage()); //NO !
            throw new Exception("Cannot UPDATE, please do later");//YES
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

ALTER TABLE Book DROP CONSTRAINT FK_CategoryBook;

ALTER TABLE Book
ADD CONSTRAINT FK_CategoryBook
FOREIGN KEY (categoryId) REFERENCES Category(categoryId);

INSERT INTO Book(code, bookName, price, categoryId) VALUES("java11", "prgo nmnds java", 123.4, 1);
INSERT INTO Category(categoryName, categoryId) VALUES("food", 1);
INSERT INTO Category(categoryName, categoryId) VALUES("hoc lam giau", 2);
INSERT INTO Category(categoryName, categoryId) VALUES("programming", 3);

* */