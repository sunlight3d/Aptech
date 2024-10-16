package com.aptech.hocvien.hocvien.runners;

import com.aptech.hocvien.hocvien.models.HocVien;
import com.aptech.hocvien.hocvien.repositories.HocVienRepository;
import com.aptech.hocvien.hocvien.services.IHocVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class HocVienRunner implements CommandLineRunner {
    @Autowired
    private IHocVienService hocVienService;
    @Override
    public void run(String... args) throws Exception {
        HocVien hocVienA = new HocVien("hva", "Nguyen Van A", "c1908i",
                1.0f,2.0f,3.0f,4.0f);
        hocVienService.addNew(hocVienA);
        HocVien hocVienB = new HocVien("hvb", "Nguyen Van B", "a1905z",
                1.0f,2.0f,3.0f,4.0f);
        hocVienService.addNew(hocVienB);
        HocVien hocVienC = new HocVien("hvc", "Nguyen Van C", "a2002l",
                1.0f,2.0f,3.0f,4.0f);
        hocVienService.addNew(hocVienC);
    }
}
