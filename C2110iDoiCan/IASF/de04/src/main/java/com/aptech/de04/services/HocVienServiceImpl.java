package com.aptech.de04.services;

import com.aptech.de04.models.HocVien;
import com.aptech.de04.respositories.HocVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class HocVienServiceImpl implements HocVienService{
    private final HocVienRepository hocVienRepository;
    @Override
    public List<HocVien> findAll() {
        return hocVienRepository.findAll();
    }

    @Override
    public HocVien findHocVienByName(String name) {
        return hocVienRepository.findHocVienByName(name);
    }

    @Override
    public void inputHocViens() {
        System.out.println("So hoc vien la: ");
        int n = (new Scanner(System.in)).nextInt();
        for(int i = 0; i < n; i++) {
            HocVien hocVien = new HocVien();
            hocVien.input();
            hocVienRepository.addHocVien(hocVien);
        }
    }
}
