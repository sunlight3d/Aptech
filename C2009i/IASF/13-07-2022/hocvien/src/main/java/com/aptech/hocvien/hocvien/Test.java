package com.aptech.hocvien.hocvien;

import com.aptech.hocvien.hocvien.models.HocVien;
import com.aptech.hocvien.hocvien.services.HocVienService;
import com.aptech.hocvien.hocvien.services.IHocVienService;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Scanner;
@Log4j2
public class Test {
    private IHocVienService hocVienService;
    public Test(IHocVienService hocVienService) {
        this.hocVienService = hocVienService;
    }
    public void testAll() {

        int choice = 0;

        while(choice != 4) {
            log.info("Enter your choice(1,2,3), 4 to exit : ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1: {
                    List<HocVien>hocViens = this.hocVienService.findAll();
                    for (HocVien hocvien: hocViens) {
                        System.out.println(hocvien.toString());
                    }
                    break;
                }
                case 2: {
                    log.info("Enter name to search: ");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    HocVien hocVien = this.hocVienService.findHocVienByName(name);
                    if(hocVien == null) {
                        System.err.println("Cannot find this person");
                    } else {

                        log.info("Found: {}",hocVien.toString());
                    }
                    break;
                }
                case 3: {
                    log.info("Please enter hocvien information");
                    HocVien hocVien = HocVien.input();
                    this.hocVienService.addNew(hocVien);
                }
                default:
                    break;
            }
        }
        System.out.println("Program exit!");
    }
}
