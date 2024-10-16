package com.aptech.apidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Viet api register, login user
//data = in-memory (H2)
public class ApidemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApidemoApplication.class, args);
	}
}
