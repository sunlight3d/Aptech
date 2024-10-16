package com.aptech.hocvien.hocvien.services;

import com.aptech.hocvien.hocvien.models.HocVien;
import com.aptech.hocvien.hocvien.repositories.HocVienRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
//1 service => use many repositories
public class HocVienService implements IHocVienService{
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
        log.info("haha");
        hocVienRepository.addNew(hv);
    }
}


