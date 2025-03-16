package org.university.app.services;
import org.university.app.database.DatabaseHelper;

import java.sql.*;

public class GradeService {
    public static void getStudentGrade(int studentID, int moduleID, int assessmentID) {
        String sql = "SELECT AwardedMarks, MaximumMarks FROM Assessment WHERE StudentID=? AND AssessmentID=?";
        try (Connection conn = DatabaseHelper.connect()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, studentID);
                pstmt.setInt(2, assessmentID);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    int marks = rs.getInt("AwardedMarks");
                    int maxMarks = rs.getInt("MaximumMarks");
                    double percentage = (marks / (double) maxMarks) * 100;

                    // Phân loại học sinh dựa trên bảng tiêu chí
                    String classification = classifyGrade(percentage);

                    System.out.println("Student " + studentID + " scored: " + marks + "/" + maxMarks +
                            " (" + String.format("%.2f", percentage) + "%) - Classification: " + classification);
                } else {
                    System.out.println("No record found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static String classifyGrade(double percentage) {
        if (percentage < 40) {
            return "Fail";
        } else if (percentage < 50) {
            return "3rd Class Pass";
        } else if (percentage < 60) {
            return "2nd Class 2nd Division";
        } else if (percentage < 70) {
            return "2nd Class 1st Division";
        } else {
            return "First Class";
        }
    }
}
