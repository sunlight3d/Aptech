package com.aptech.nguyenvana.exam.repositories;

import com.aptech.nguyenvana.exam.models.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class HocVienRepository {
    private List<HocVien> hocViens;
    public HocVienRepository() {
        generateData();
    }
    public void generateData() {
        HocVien hocVienA = new HocVien(1L, "nguyen van A",
                "c1111", 8.0f, 7.0f, 6.0f, 9.0f);
        HocVien hocVienB = new HocVien(2L, "nguyen van B",
                "c1111", 7.0f, 7.0f, 9.0f, 5.0f);
        HocVien hocVienC = new HocVien(3L, "nguyen van C",
                "c2222", 6.0f, 10.0f, 5.0f, 4.0f);
        hocViens = List.of(hocVienA, hocVienB, hocVienC);

    }
    public List<HocVien> findAll() {
        return hocViens;
    }
    public HocVien findHocVienByName(String name){
        Optional<HocVien> hocVien = hocViens.stream().filter(hv -> hv.getHo_va_ten().trim().equals(name.trim()))
                .findFirst();
        if(hocVien.isPresent()) {
            return hocVien.get();
        }
        return null;
    }
    public void addNew(HocVien hv) {
        hocViens.add(hv);
    }
}
