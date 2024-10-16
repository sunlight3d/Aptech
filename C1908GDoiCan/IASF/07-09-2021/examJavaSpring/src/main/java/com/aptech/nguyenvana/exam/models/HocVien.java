package com.aptech.nguyenvana.exam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Scanner;

@Entity
//POJO = Plain Object Java Object
public class HocVien {
    @Id
    private Long ma_hoc_vien;
    @Column(nullable = false, length = 300)
    private String ho_va_ten;
    private String lop_hoc;
    private Float diem_mon_a;
    private Float diem_mon_b;
    private Float diem_mon_c;
    private Float diem_mon_d;
    public HocVien() {

    }

    public HocVien(Long ma_hoc_vien, String ho_va_ten, String lop_hoc,
                   Float diem_mon_a, Float diem_mon_b, Float diem_mon_c, Float diem_mon_d) {
        this.ma_hoc_vien = ma_hoc_vien;
        this.ho_va_ten = ho_va_ten;
        this.lop_hoc = lop_hoc;
        this.diem_mon_a = diem_mon_a;
        this.diem_mon_b = diem_mon_b;
        this.diem_mon_c = diem_mon_c;
        this.diem_mon_d = diem_mon_d;
    }

    public Long getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(Long ma_hoc_vien) {
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
        diem_trung_binh = (diem_mon_a + diem_mon_b + diem_mon_c + diem_mon_d)/4;
        return diem_trung_binh;
    }

    public KetQua getKet_qua() {
        Float diemTrungBinh = this.getDiem_trung_binh();
        return diemTrungBinh < 5 ? KetQua.YEU : (
                diemTrungBinh >=5 && diemTrungBinh <= 6 ? KetQua.TB :
                        (diemTrungBinh > 6 && diemTrungBinh <= 8 ? KetQua.KHA : KetQua.GIOI)
                );
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hoten: ");
        this.ho_va_ten = scanner.next();
        System.out.println("Enter lophoc: ");
        this.lop_hoc = scanner.next();
        System.out.println("Enter diem mon A: ");
        this.diem_mon_a = scanner.nextFloat();
        System.out.println("Enter diem mon B: ");
        this.diem_mon_b = scanner.nextFloat();
        System.out.println("Enter diem mon C: ");
        this.diem_mon_c = scanner.nextFloat();
        System.out.println("Enter diem mon D: ");
        this.diem_mon_d = scanner.nextFloat();
    }
    @Transient
    private Float diem_trung_binh;
    @Transient
    private KetQua ket_qua;
}
