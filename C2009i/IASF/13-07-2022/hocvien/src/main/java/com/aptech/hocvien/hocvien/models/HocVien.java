package com.aptech.hocvien.hocvien.models;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;
@Getter
@Setter
@Log4j2
public class HocVien {
    private String ma_hoc_vien;
    private String ho_va_ten;
    private String lop_hoc;
    private Float diem_mon_a;
    private Float diem_mon_b;
    private Float diem_mon_c;
    private Float diem_mon_d;

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public Float diem_trung_binh() {
        return (diem_mon_a + diem_mon_b + diem_mon_c + diem_mon_d)/4;
    }
    public String ket_qua() {
        Float diemTrungBinh = diem_trung_binh();
        //nested ternary
        return diemTrungBinh < 5 ? "YEU" : (
                diemTrungBinh >= 5 && diemTrungBinh <= 6 ? "TB":
                        (diemTrungBinh > 6 && diemTrungBinh <= 8) ? "KHA" :
                                (diemTrungBinh > 8 ? "GIOI" : "YEU")
                );
    }



    public HocVien() {}
    public HocVien(String ma_hoc_vien, String ho_va_ten,
                   String lop_hoc,
                   Float diem_mon_a, Float diem_mon_b, Float diem_mon_c, Float diem_mon_d
                   ) {
        log.info("create hocvien with name: {}", ho_va_ten);
        this.ma_hoc_vien = ma_hoc_vien;
        this.ho_va_ten = ho_va_ten;
        this.lop_hoc = lop_hoc;
        this.diem_mon_a = diem_mon_a;
        this.diem_mon_b = diem_mon_b;
        this.diem_mon_c = diem_mon_c;
        this.diem_mon_d = diem_mon_d;
        //calculated properties
        //this.diem_trung_binh = diem_trung_binh(); //calculated fields
        //this.ket_qua = getKet_qua();
    }

    /*
    public String getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(String ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public String getHo_va_ten() {
        return ho_va_ten;
    }

    public void setHo_va_ten(String ho_va_ten) {
        this.ho_va_ten = ho_va_ten;
    }

    public String getLop_hoc() {
        return lop_hoc;
    }

    public void setLop_hoc(String lop_hoc) {
        this.lop_hoc = lop_hoc;
    }

    public Float getDiem_mon_a() {
        return diem_mon_a;
    }

    public void setDiem_mon_a(Float diem_mon_a) {
        this.diem_mon_a = diem_mon_a;
    }

    public Float getDiem_mon_b() {
        return diem_mon_b;
    }

    public void setDiem_mon_b(Float diem_mon_b) {
        this.diem_mon_b = diem_mon_b;
    }

    public Float getDiem_mon_c() {
        return diem_mon_c;
    }

    public void setDiem_mon_c(Float diem_mon_c) {
        this.diem_mon_c = diem_mon_c;
    }

    public Float getDiem_mon_d() {
        return diem_mon_d;
    }

    public void setDiem_mon_d(Float diem_mon_d) {
        this.diem_mon_d = diem_mon_d;
    }

    public Float getDiem_trung_binh() {
        return (diem_mon_a + diem_mon_b + diem_mon_c + diem_mon_d)/4;
    }

    public void setDiem_trung_binh(Float diem_trung_binh) {
        this.diem_trung_binh = diem_trung_binh;
    }
    public void setKet_qua(String ket_qua) {
        this.ket_qua = ket_qua;
    }
    */
    @Override
    public String toString() {
        return "HocVien{" +
                "ma_hoc_vien='" + ma_hoc_vien + '\'' +
                ", ho_va_ten='" + ho_va_ten + '\'' +
                ", lop_hoc='" + lop_hoc + '\'' +
                ", diem_mon_a=" + diem_mon_a +
                ", diem_mon_b=" + diem_mon_b +
                ", diem_mon_c=" + diem_mon_c +
                ", diem_mon_d=" + diem_mon_d +
                ", diem_trung_binh=" + diem_trung_binh() +
                ", ket_qua='" + ket_qua() + '\'' +
                '}';
    }
    public static HocVien input() {
        //factory method
        System.out.println("Enter ma_hoc_vien");
        String ma_hoc_vien = getScanner().next();

        System.out.println("Enter ho_va_ten");
        String ho_va_ten = getScanner().next();

        System.out.println("Enter lop_hoc");
        String lop_hoc = getScanner().next();

        System.out.println("Enter diem_mon_a");
        Float diem_mon_a = getScanner().nextFloat();

        System.out.println("Enter diem_mon_b");
        Float diem_mon_b = getScanner().nextFloat();

        System.out.println("Enter diem_mon_c");
        Float diem_mon_c = getScanner().nextFloat();

        System.out.println("Enter diem_mon_d");
        Float diem_mon_d = getScanner().nextFloat();
        return new HocVien(ma_hoc_vien, ho_va_ten, lop_hoc,
                diem_mon_a, diem_mon_b, diem_mon_c,diem_mon_d);
    }
}
