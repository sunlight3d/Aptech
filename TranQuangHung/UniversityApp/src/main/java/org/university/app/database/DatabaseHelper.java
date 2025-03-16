package org.university.app.database;

import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:university.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
