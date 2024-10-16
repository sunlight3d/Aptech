package com.aptech.de04;
import  com.aptech.de04.models.*
import com.aptech.de04.services.HocVienService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		HocVienService hocVienService = context.getBean(HocVienService.class);
		hocVienService.inputHocViens();
		hocVienService.findAll().forEach(hocVien -> System.out.println(hocVien.toString()));
		HocVien hocvien = hocVienService.findHocVienByName("nam");
		if(hocvien != null) {
			System.out.println(hocvien);
		} else {
			System.out.println("Ko tim thay");
		}

	}

}
