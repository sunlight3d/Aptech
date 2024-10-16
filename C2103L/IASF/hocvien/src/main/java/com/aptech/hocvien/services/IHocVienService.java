package com.aptech.hocvien.services;

import com.aptech.hocvien.models.Hocvien;

import java.util.List;
public interface IHocVienService {
    List<Hocvien> findAll();
    Hocvien findHocvienByName(String name);
    void addNew(Hocvien hocvien);
}
