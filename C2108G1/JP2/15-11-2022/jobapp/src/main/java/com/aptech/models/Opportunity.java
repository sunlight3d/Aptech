package com.aptech.models;

import com.aptech.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.aptech.Helper.getBufferReader;

public class Opportunity {
    private String  id;
    private String  jobTitle;
    private Float   expectedSalary;
    private List<String> skills;
    private List<String>  education;
    public void input() {
        try {
            System.out.println("Enter id:");
            this.id = getBufferReader().readLine();

            while (true) {
                System.out.println("Enter jobtitle:");
                String jobtitle = getBufferReader().readLine();
                jobTitle = jobtitle.trim().replaceAll("\\s+", " ");
                if(jobtitle.length() < 10) {
                    System.err.println("Job title must be >= 10");
                } else {
                    this.jobTitle = jobTitle;
                    break;
                }
            }
            while (true) {
                System.out.println("Enter expectedSalary:");
                Float expectedSalary = Float.valueOf(getBufferReader().readLine());
                if(expectedSalary <= 20) {
                    System.err.println("expected salary must > 20");
                } else {
                    this.expectedSalary = expectedSalary;
                    break;
                }
            }

            while (true) {
                System.out.println("Enter skills(at least 2). Example: english, music");
                List<String> skills = Arrays.asList((getBufferReader().readLine().split(",")));
                if(skills.size() < 2) {
                    System.err.println("You must input at least 2 skills");
                } else {
                    this.skills = skills;
                    break;
                }
            }
            List<String> education = new ArrayList<String>();
            while (true) {
                System.out.println("Enter education(at least 1), leave blank if exit");
                String eachEducation = getBufferReader().readLine();
                if(eachEducation.trim().length() == 0) {
                    break;
                } else {
                    education.add(eachEducation);
                    if(education.size() < 1) {
                        System.err.println("You must input at least 1 education");
                    }
                }
            }
            this.education = education;
        }catch (IOException e) {
            System.err.println("Invalid input: "+e.getMessage());
        }

    }
    public Opportunity() {

    }
    public Opportunity(String id,
                       String jobTitle,
                       Float expectedSalary,
                       List<String> skills,
                       List<String> education) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.expectedSalary = expectedSalary;
        this.skills = skills;
        this.education = education;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Float getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Float expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id='" + id + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", expectedSalary=" + expectedSalary +
                ", skills=" + skills +
                ", education=" + education +
                '}';
    }
}
