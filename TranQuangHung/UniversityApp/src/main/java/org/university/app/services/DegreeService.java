package org.university.app.services;

public class DegreeService {
    public static void getFinalDegreeClassification(int studentID) {
        // Giả sử kết quả tổng hợp các môn theo một quy tắc đơn giản
        double finalScore = 75.0; // Giả định giá trị từ database

        String classification;
        if (finalScore >= 70) {
            classification = "First Class";
        } else if (finalScore >= 60) {
            classification = "Upper Second Class";
        } else if (finalScore >= 50) {
            classification = "Lower Second Class";
        } else if (finalScore >= 40) {
            classification = "Third Class";
        } else {
            classification = "Fail";
        }

        System.out.println("Final degree classification: " + classification);
    }
}
