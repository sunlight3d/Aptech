package com.aptech.hocvien.hocvien.repositories;

import com.aptech.hocvien.hocvien.models.HocVien;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Repository
@NoArgsConstructor
public class HocVienRepository {
    private List<HocVien> hocViens = new ArrayList<HocVien>();
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
