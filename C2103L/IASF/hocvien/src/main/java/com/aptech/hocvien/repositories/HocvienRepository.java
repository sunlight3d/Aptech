package com.aptech.hocvien.repositories;

import com.aptech.hocvien.models.Hocvien;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HocvienRepository {
    private List<Hocvien> hocvienList = new ArrayList<>(List.of(
            Hocvien.builder()
                    .id(1L)
                    .fullName("Nguyen Van A")
                    .markA(6)
                    .markB(7)
                    .markC(8)
                    .markD(9)
                    .build(),
            Hocvien.builder()
                    .id(2L)
                    .fullName("Nguyen Van B")
                    .markA(5)
                    .markB(6)
                    .markC(7)
                    .markD(8)
                    .build(),
            Hocvien.builder()
                    .id(3L)
                    .fullName("Nguyen Van C")
                    .markA(9)
                    .markB(9)
                    .markC(10)
                    .markD(10)
                    .build(),
            Hocvien.builder()
                    .id(4L)
                    .fullName("Nguyen Van D")
                    .markA(1)
                    .markB(2)
                    .markC(3)
                    .markD(4)
                    .build()
    ));
    public List<Hocvien> findAll() {
        return hocvienList;
    }
    public Hocvien findHocvienByName(String name) {
        return hocvienList.stream().filter(item ->item.getFullName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
    public void addNew(Hocvien hocvien) {
        hocvienList.add(hocvien);
    }
}
