package com.aptech.de02;

import com.aptech.de02.models.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class De02Application {

	public static void main(String[] args) {
		Patient patient = Patient.builder()
				.email("haha@gmail.com")
				.build();
		System.out.println(patient.getEmail());
		SpringApplication.run(De02Application.class, args);
	}

}
