package com.projecta.projecta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectaApplication {

	public static void main(String[] args) {
		/*
		ConfigManager c1 = ConfigManager.getInstance();
		ConfigManager c2 = ConfigManager.getInstance();
		ConfigManager c3 = ConfigManager.getInstance();
		 */
		SpringApplication.run(ProjectaApplication.class, args);
	}

}
