package com.aptech.de04.respositories;

import com.aptech.de04.models.HocVien;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class HocVienRepository {
    List<HocVien> hocVienList = new ArrayList<>(Arrays.asList(
            HocVien.builder()
                    .hoVaTen("Nguyen Van A")
                    .lopHoc("C1234L")
                    .diemMonA(9.5)
                    .diemMonB(8.2)
                    .diemMonC(7.8)
                    .diemMonD(6.9)
                    .diemTrungBinh(8.6)
                    .ketQua("Pass")
                    .build(),

            HocVien.builder()
                    .hoVaTen("Tran Thi B")
                    .lopHoc("C5678L")
                    .diemMonA(7.9)
                    .diemMonB(8.6)
                    .diemMonC(8.4)
                    .diemMonD(7.5)
                    .diemTrungBinh(8.1)
                    .ketQua("Pass")
                    .build()
    ));
    public List<HocVien> findAll() {
        return this.hocVienList;
    }

    public HocVien findHocVienByName(String name) {
        return hocVienList.stream()
                .filter(hocVien -> hocVien
                        .getHoVaTen().toLowerCase().equals(name.toLowerCase().trim()))
                .findFirst().get();
    }
    public void addHocVien(HocVien hocVien) {
        this.hocVienList.add(hocVien);
    }
}
/*
maHocVien;
    private String hoVaTen;
    private String lopHoc;
    private double diemMonA;
    private double diemMonB;
    private double diemMonC;
    private double diemMonD;
    private double diemTrungBinh;
    private String ketQua;
* */

