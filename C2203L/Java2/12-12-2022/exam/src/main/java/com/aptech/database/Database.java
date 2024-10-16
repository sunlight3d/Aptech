package com.aptech.database;

import com.aptech.Helper;
import com.aptech.models.Exam;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost:3311/c2203L";//connection string
    static final String USER = "root";
    static final String PASSWORD = "Abc123456789";
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

    public ArrayList<Exam> getExams() throws Exception{
        ArrayList<Exam> result = new ArrayList<Exam>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+ TABLE_EXAM);
            // Extract data from result set
            while (resultSet.next()) {
                // Fetch data to object
                Exam exam = new Exam();
                exam.setId(resultSet.getInt("id"));
                exam.setExamName(resultSet.getString("exam_name"));
                exam.setExamDate(resultSet.getDate("exam_date"));
                exam.setExamDuration(resultSet.getInt("exam_duration"));
                exam.setExamRoom(resultSet.getString("exam_room"));
                result.add(exam);
            }
            return result;
        } catch (Exception exception) {
            throw new Exception("Cannot get exams from DB");
        }
    }
    public Exam getExamByID(int id) throws Exception{
        try {
            Statement statement = this.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM "+
                    TABLE_EXAM + " WHERE id = %d", id));
            // Extract data from result set
            while (resultSet.next()) {
                // Fetch data to object
                Exam exam = new Exam();
                exam.setId(resultSet.getInt("id"));
                exam.setExamName(resultSet.getString("exam_name"));
                //exam.setExamDate();
                exam.setExamDuration(resultSet.getInt("exam_duration"));
                exam.setExamRoom(resultSet.getString("exam_room"));
                return exam;
            }
            return null;
        } catch (Exception exception) {
            throw new Exception("Cannot get exam by ID");
        }
    }
    public void insertExam(String examName, java.sql.Date examDate, int examDuration, String examRoom)
            throws Exception{
        try {
            String sql = "INSERT INTO "+ TABLE_EXAM +"(exam_name, exam_date, exam_duration, exam_room) " +
                    "VALUES(?, ?, ?, ?);";
            PreparedStatement statement = this.getConnection()
                    .prepareStatement(sql);
            //prevent SQL injection
            statement.setString(1, examName);
            statement.setDate(2, examDate);
            statement.setInt(3, examDuration);
            statement.setString(4, examRoom);
            statement.executeUpdate();
        } catch (Exception exception) {
            //throw new Exception(exception.getMessage()); //NO !
            throw new Exception("Cannot insert, please do later");//YES
        }
    }
    public void deleteExam(int id) throws Exception{
        try {
            String sql = "DELETE FROM "+ TABLE_EXAM +" WHERE id = ?;";
            PreparedStatement statement = this.getConnection()
                    .prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception exception) {
            //throw new Exception(exception.getMessage()); //NO !
            throw new Exception("Cannot delete, please do later");//YES
        }
    }
}

/*
CREATE DATABASE c2203L;
USE c2203L;
CREATE TABLE tbl_exam(
    id INT PRIMARY KEY AUTO_INCREMENT,
    exam_name VARCHAR(50),
    exam_date DATE,
    exam_duration INT,
    exam_room VARCHAR(10)
);
* */