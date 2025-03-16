package org.university.app.models;

public class Assessment {
    private int assessmentID;
    private String type;
    private int maxMarks;
    private int awardedMarks;
    private int studentID;

    public Assessment(int assessmentID, String type, int maxMarks, int awardedMarks, int studentID) {
        this.assessmentID = assessmentID;
        this.type = type;
        this.maxMarks = maxMarks;
        this.awardedMarks = awardedMarks;
        this.studentID = studentID;
    }

    public int getAssessmentID() { return assessmentID; }
    public int getAwardedMarks() { return awardedMarks; }
    public int getMaxMarks() { return maxMarks; }
}
