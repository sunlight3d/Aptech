package com.jobs.recruitment.fulltime;

import com.jobs.recruitment.JobApplication;

import java.util.Scanner;

public class FullTimeJobApplication extends JobApplication {
    private double annualSalary;
    private String jobLocation;
    private Scanner getScanner() {
        return  new Scanner(System.in);
    }

    public FullTimeJobApplication() {
    }

    public FullTimeJobApplication(String applicationID,
                                  String jobTitle,
                                  String applicationDate,
                                  int numberOfApplicants,
                                  double annualSalary,
                                  String jobLocation) {
        super(applicationID, jobTitle, applicationDate, numberOfApplicants);
        this.annualSalary = annualSalary;
        this.jobLocation = jobLocation;
    }

    @Override
    public void input() {
        System.out.println("Enter application's id : ");
        this.setApplicationID(getScanner().next());

        System.out.println("Enter job title :");
        this.setJobTitle(getScanner().next());

        System.out.println("Enter application date(MM/dd/yyyy) :");
        this.setJobTitle(getScanner().next());
    }

    @Override
    public void display() {

    }
}
