package com.aptech.de04.services;

import com.aptech.de04.models.HocVien;

import java.util.List;

public interface HocVienService {
    List<HocVien> findAll();
    HocVien findHocVienByName(String name);
    void inputHocViens();
}
