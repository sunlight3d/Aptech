package org.university.app.services;
import org.university.app.database.DatabaseHelper;

import java.sql.*;

public class ModuleService {
    public static void getWeightedAverage(int studentID, int moduleID) {
        String sql = "SELECT a.AwardedMarks, a.MaximumMarks " +
                "FROM Assessment a " +
                "JOIN AssessmentStructure s ON a.AssessmentID = s.AssessmentID " +
                "WHERE a.StudentID = ? AND s.ModuleID = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentID);
            pstmt.setInt(2, moduleID);

            ResultSet rs = pstmt.executeQuery();
            double totalMarks = 0, totalWeight = 0;

            while (rs.next()) {
                double marks = rs.getDouble("AwardedMarks");
                double maxMarks = rs.getDouble("MaximumMarks");
                double weight = maxMarks; // Giả sử điểm tối đa là trọng số
                totalMarks += (marks / maxMarks) * weight;
                totalWeight += weight;
            }

            double finalGrade = (totalMarks / totalWeight) * 100;
            System.out.println("Weighted grade for module " + moduleID + ": " + finalGrade + "%");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
