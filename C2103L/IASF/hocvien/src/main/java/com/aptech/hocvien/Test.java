package com.aptech.hocvien;

import com.aptech.hocvien.models.Hocvien;
import com.aptech.hocvien.services.HocvienService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

//@RequiredArgsConstructor
@Component
public class Test {
    @Autowired
    private HocvienService hocvienService;
    private Scanner getScanner(){
        return new Scanner(System.in);
    }
    public void menu() {
        int choice = 0;
        while(choice != 4) {
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(getScanner().next());
            switch (choice) {
                case 1 -> {
                    List<Hocvien> hocvienList = hocvienService.findAll();
                    hocvienList.forEach(item -> {
                        System.out.println(item);
                        System.out.println(item.getResult());
                    });
                }
                case 2 -> {
                    System.out.println("Enter name to search: ");
                    String name = getScanner().nextLine();
                    Hocvien hocvien = hocvienService.findHocvienByName(name);
                    if (hocvien != null) {
                        System.out.println(hocvien);
                    }
                }
                case 3 -> {
                    Hocvien newHocvien = new Hocvien();
                    newHocvien.input();
                    hocvienService.addNew(newHocvien);
                }
                default -> System.out.println("Please enter 1,2,3");
            }
        }
    }
}
