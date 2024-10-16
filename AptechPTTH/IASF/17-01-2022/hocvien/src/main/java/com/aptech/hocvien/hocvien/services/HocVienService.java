package com.aptech.hocvien.hocvien.services;

import com.aptech.hocvien.hocvien.models.HocVien;
import com.aptech.hocvien.hocvien.repositories.HocVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocVienService {
    @Autowired
    private HocVienRepository hocVienRepository;
    public List<HocVien> findAll() {
        return hocVienRepository.findAll();
    }
    //input tu console => WHERE controller ??
    public HocVien findHocVienByName(String name) {
        return hocVienRepository.findHocVienByName(name);
    }
    public void addNew(HocVien hv) {
        hocVienRepository.addNew(hv);
    }
}
