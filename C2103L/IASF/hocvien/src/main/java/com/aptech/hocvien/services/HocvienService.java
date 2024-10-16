package com.aptech.hocvien.services;

import com.aptech.hocvien.models.Hocvien;
import com.aptech.hocvien.repositories.HocvienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HocvienService implements IHocVienService{
    private final HocvienRepository hocvienRepository;
    @Override
    public List<Hocvien> findAll() {
        return hocvienRepository.findAll();
    }
    @Override
    public Hocvien findHocvienByName(String name) {
        return hocvienRepository.findHocvienByName(name);
    }

    @Override
    public void addNew(Hocvien hocvien) {
        hocvienRepository.addNew(hocvien);
    }

}
