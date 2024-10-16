package com.aptech.nguyenvana.exam.services;

import com.aptech.nguyenvana.exam.models.HocVien;
import com.aptech.nguyenvana.exam.repositories.HocVienRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HocVienService {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(HocVienService.class);
    @Autowired
    private HocVienRepository repository;
    public List<HocVien> findAll() {
        return repository.findAll();
    }
    public HocVien findHocVienByName(String name) {
        HocVien foundHocvien = repository.findHocVienByName(name);
        if(foundHocvien == null) {
            logger.info("Not Found");
        }
        return repository.findHocVienByName(name);
    }
    public void addNew(HocVien hocVien) {
        repository.addNew(hocVien);
    }
}
