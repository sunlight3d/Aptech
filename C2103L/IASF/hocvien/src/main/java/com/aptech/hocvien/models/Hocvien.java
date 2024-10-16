package com.aptech.hocvien.models;

import lombok.*;

import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Hocvien {
    private Long id;
    private String fullName;
    private float markA;
    private float markB;
    private float markC;
    private float markD;
    public float getAverage() {
        return (markA+markB+markC+markD)/4;
    }
    public String getResult() {
        float average = getAverage();
        return average < 5 ? Result.YEU :
                (average >= 5 && average <= 6 ? Result.TB :
                        (average > 6 && average <= 8 ? Result.KHA
                                : (average > 8 ? Result.GIOI : Result.KHONG_XAC_DINH)));
    }
    private Scanner getScanner() {
        return new Scanner(System.in);
    }
    public void input() {
        System.out.println("Enter id: ");
        this.id = Long.valueOf(getScanner().next());

        System.out.println("Enter fullname: ");
        this.fullName = getScanner().next();

        System.out.println("Enter markA = ");
        this.markA = Float.valueOf(getScanner().next());

        System.out.println("Enter markB = ");
        this.markB = Float.valueOf(getScanner().next());

        System.out.println("Enter markC = ");
        this.markC = Float.valueOf(getScanner().next());

        System.out.println("Enter markD = ");
        this.markD = Float.valueOf(getScanner().next());
    }
}
