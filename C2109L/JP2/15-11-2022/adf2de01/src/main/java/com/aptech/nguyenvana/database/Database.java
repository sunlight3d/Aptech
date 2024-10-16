package com.aptech.nguyenvana.database;

import java.sql.*;
import java.time.ZoneId;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;

import com.aptech.nguyenvana.ExamNotFoundException;
import com.aptech.nguyenvana.models.*;

import static com.aptech.nguyenvana.ExamNotFoundException.HIGH_SEVERITY;

public class Database {
    private Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost:3306/c2109l";//connection string
    static final String USER = "root";
    static final String PASSWORD = "";
    public static String TABLE_EXAM = "tbl_exam";
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
    public void insertExam(
            String  name,
            Date    date,
            int     duration,
            String  room
    ) throws Exception {
        try {
            String sql = "INSERT INTO "+TABLE_EXAM+
                    "(exam_name,exam_date,exam_duration,exam_room) " +
                    "VALUES(?, ?, ?, ?);";
            PreparedStatement statement = this.getConnection()
                    .prepareStatement(sql);
            //prevent SQL injection
            statement.setString(1, name);
            statement.setDate(2,new java.sql.Date(date.getTime()));
            statement.setInt(3, duration);
            statement.setString(4, room);
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new Exception("Cannot insert, please do later");//YES
        }
    }
    public ArrayList<Exam> getExams() throws Exception{
        ArrayList<Exam> result = new ArrayList<Exam>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+TABLE_EXAM);
            // Extract data from result set
            while (resultSet.next()) {
                // Fetch data to object
                Exam exam = new Exam();
                exam.setName(resultSet.getString("exam_name"));
                exam.setDate(resultSet.getDate("exam_date"));
                exam.setDuration(resultSet.getInt("name"));
                exam.setRoom(resultSet.getString("exam_room"));
                result.add(exam);
            }
            return result;
        } catch (Exception exception) {
            throw exception;
        }
    }
    public Exam getExamById(int examId) throws Exception{
        Exam exam = null;
        Statement statement = this.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+TABLE_EXAM+
                " WHERE id = "+examId);
        while (resultSet.next()) {
            // Fetch data to object
            exam = new Exam();
            exam.setName(resultSet.getString("exam_name"));
            exam.setDate(resultSet.getDate("exam_date"));
            exam.setDuration(resultSet.getInt("name"));
            exam.setRoom(resultSet.getString("exam_room"));
        }
        if(exam == null) {
            throw new ExamNotFoundException("Cannot find exam", HIGH_SEVERITY);
        }
        return exam;
    }
    public void deleteBook(int id) throws Exception{
        getExamById(id);
        String sql = "DELETE FROM "+TABLE_EXAM+
                " WHERE id = ?;";
        PreparedStatement statement = this.getConnection()
                .prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
/*
CREATE DATABASE c2109l;
USE c2109l;
CREATE TABLE tbl_exam(
    id INT PRIMARY KEY AUTO_INCREMENT,
    exam_name VARCHAR(50),
    exam_date DATE,
    exam_duration INT,
    exam_room VARCHAR(10)
);


* */
