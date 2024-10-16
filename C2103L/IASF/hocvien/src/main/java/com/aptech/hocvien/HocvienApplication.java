package com.aptech.hocvien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HocvienApplication {

	public static void main(String[] args) {
		SpringApplication.run(HocvienApplication.class, args);
		ApplicationContext context = SpringApplication.run(HocvienApplication.class, args);
		Test test = context.getBean(Test.class);
		test.menu();

	}

}
