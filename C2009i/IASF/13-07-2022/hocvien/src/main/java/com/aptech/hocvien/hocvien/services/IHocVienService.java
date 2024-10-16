package com.aptech.hocvien.hocvien.services;

import com.aptech.hocvien.hocvien.models.HocVien;

import java.util.List;

public interface IHocVienService {
    List<HocVien> findAll();
    /*
    Find all by name
    * */
    HocVien findHocVienByName(String name);
    void addNew(HocVien hv);
}
