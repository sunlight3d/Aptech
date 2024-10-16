package com.oppotunity;

import lombok.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.oppotunity.Helper.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data //getter, setter,to String
//@Builder
public class Oppotunity implements Serializable {

    private String id = "";
    private String jobTitle = "";
    private float expectedSalary = 0;
    private List<String> skills = new ArrayList<String>();
    private List<String> education = new ArrayList<String>();
    public Oppotunity() {
    }
    public void input() {
        this.id = inputString("Enter id: ");
        while(this.jobTitle.length() < 10) {
            this.jobTitle = inputString("Enter job title: ");
            if(this.jobTitle.length() < 10) {
                System.err.println("job title must be < 10 chars");
            }
        }
        while(this.expectedSalary <= 20) {
            this.expectedSalary = inputFloat("Expected salary:");
            if (this.expectedSalary <= 20) {
                System.err.println("salary must be > 20");
            }
        }
        boolean isContinue = true;
        while (true) {
            String skill = inputString("Enter skill:");
            if(skill.length() == 0) {
                if(this.skills.size() >= 2) {
                    break;
                } else {
                    System.err.println("You must enter at least 2 skills");
                }
            } else {
                this.skills.add(skill);
            }
        }
        while (true) {
            String university = inputString("Enter university:");
            if(university.length() == 0) {
                if(this.education.size() > 1) {
                    break;
                } else {
                    System.err.println("You must enter at least 1 university");
                }
            } else {
                this.education.add(university);
            }
        }
    }
    public Oppotunity(String id, String jobTitle,
                      float expectedSalary, List<String> skills, List<String> education) {
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

    public float getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(float expectedSalary) {
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
        return "Oppotunity{" +
                "id='" + id + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", expectedSalary=" + expectedSalary +
                ", skills=" + skills +
                ", education=" + education +
                '}';
    }
}
