package com.aptech.de04.models;

import lombok.*;

import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
@Builder
public class HocVien {
    private int maHocVien;
    private String hoVaTen;
    private String lopHoc;
    private double diemMonA;
    private double diemMonB;
    private double diemMonC;
    private double diemMonD;
    private double diemTrungBinh;
    private String ketQua;

    public double getDiemTrungBinh() {
        return (diemMonA + diemMonB + diemMonC + diemMonD) / 4.0;
    }
    private Scanner getScanner() {
        return new Scanner(System.in);
    }
    public void input() {
        System.out.println("Enter maHocVien: ");
        this.maHocVien = getScanner().nextInt();

        System.out.println("Enter hoVaTen: ");
        this.hoVaTen = getScanner().nextLine();

        System.out.println("Enter lopHoc: ");
        this.lopHoc = getScanner().nextLine();

        System.out.println("Enter diemMonA: ");
        this.diemMonA = getScanner().nextDouble();

        System.out.println("Enter diemMonB: ");
        this.diemMonB = getScanner().nextDouble();

        System.out.println("Enter diemMonC: ");
        this.diemMonC = getScanner().nextDouble();

        System.out.println("Enter diemMonD: ");
        this.diemMonD = getScanner().nextDouble();


    }
    String getKetQua() {
        // Calculate the average score
        this.diemTrungBinh = getDiemTrungBinh();
        // Determine the result based on the average score
        if (diemTrungBinh < 5.0) {
            this.ketQua = "YEU";
        } else if (diemTrungBinh >= 5.0 && diemTrungBinh <= 6.0) {
            this.ketQua = "TB";
        } else if (diemTrungBinh > 6.0 && diemTrungBinh <= 8.0) {
            this.ketQua = "KHA";
        } else if (diemTrungBinh > 8.0) {
            this.ketQua = "GIOI";
        }
        return ketQua;
    }

}
