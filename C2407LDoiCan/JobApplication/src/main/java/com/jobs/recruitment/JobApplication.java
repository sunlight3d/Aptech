package com.jobs.recruitment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public abstract class JobApplication {
    private String applicationID;
    private String jobTitle;
    private String applicationDate;
    private int numberOfApplicants;
    //no args constructor = default constructor
    public JobApplication() {

    }

    public JobApplication(String applicationID, String jobTitle, String applicationDate, int numberOfApplicants) {
        this.applicationID = applicationID;
        this.jobTitle = jobTitle;
        this.applicationDate = applicationDate;
        this.numberOfApplicants = numberOfApplicants;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {

        this.jobTitle = jobTitle;
    }

    public String getApplicationDate() {
        /*
        String[] dates = applicationDate.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        boolean isValidYear = year > 2000 && year <= Year.now().getValue();
        boolean isValidMonth = month >= 1 && month <= Calendar.getInstance().get(Calendar.MONTH);
        boolean isValidDay = day
         */
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            df.parse(applicationDate);
        }catch (Exception e) {
            System.err.println("Your date format is invalid");
            return null;
        }
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public int getNumberOfApplicants() {
        return numberOfApplicants;
    }

    public void setNumberOfApplicants(int numberOfApplicants) {
        this.numberOfApplicants = numberOfApplicants;
    }
    public abstract void input();
    public abstract void display();

}
