package com.aptech.hocvien.hocvien.repositories;

import com.aptech.hocvien.hocvien.models.HocVien;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Repository
public class HocVienRepository {
    private List<HocVien> hocViens = new ArrayList<HocVien>();
    public HocVienRepository() {
        HocVien hocVienA = new HocVien("hva", "Nguyen Van A", "c1908i",
                1.0f,2.0f,3.0f,4.0f);
        hocViens.add(hocVienA);
        HocVien hocVienB = new HocVien("hvb", "Nguyen Van B", "a1905z",
                1.0f,2.0f,3.0f,4.0f);
        hocViens.add(hocVienB);
        HocVien hocVienC = new HocVien("hvc", "Nguyen Van C", "a2002l",
                1.0f,2.0f,3.0f,4.0f);
        hocViens.add(hocVienC);
    }
    public List<HocVien> findAll() {
        return hocViens;
    }
    public HocVien findHocVienByName(String name) {
        return hocViens.stream()
                .filter(hocvien -> name.toLowerCase()
                        .equals(hocvien.getHo_va_ten().toLowerCase()))
                .findAny()
                .orElse(null);
    }
    public void addNew(HocVien hv) {
        hocViens.add(hv);
    }
}
