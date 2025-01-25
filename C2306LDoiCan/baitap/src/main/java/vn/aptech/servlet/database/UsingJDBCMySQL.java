package vn.aptech.servlet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsingJDBCMySQL {
    //private final static String URL = "jdbc:mysql://195.35.32.129:3306/wcd?useSSL=false";
    private final static String URL = "jdbc:mysql://Nguyens-Mac-mini.local:3309/wcd?useSSL=false";
//    private final static String USER = "dev";
//    private final static String PASS = "Udit250502@";
    private final static String USER = "root";
    private final static String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }
    public static void getStudents() {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from student");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            System.out.println("Error getting students: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        getStudents();
    }
}
