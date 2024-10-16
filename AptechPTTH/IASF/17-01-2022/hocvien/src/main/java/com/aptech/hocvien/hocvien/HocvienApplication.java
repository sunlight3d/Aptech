package com.aptech.hocvien.hocvien;

import com.aptech.hocvien.hocvien.services.HocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HocvienApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(HocvienApplication.class, args);
		HocVienService hocVienService = applicationContext.getBean(HocVienService.class);
		Test test = new Test(hocVienService);
		test.testAll();
	}

}
