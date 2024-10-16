package com.aptech;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private String studentNumber;
    private String studentName;
    private String studentAddress;
    private int studentAge;

    public void input() {
        System.out.println("Enter student number:");
        this.studentNumber = Helper.getScanner().next();

        System.out.println("Enter student's name:");
        this.studentName = Helper.getScanner().next();

        System.out.println("Enter student's address:");
        this.studentAddress = Helper.getScanner().next();

        System.out.println("Enter student's age:");
        this.studentAge = Helper.getScanner().nextInt();
    }

}
