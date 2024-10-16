package com.aptech.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import repositories.UserRepository;
import controllers.UserController;
@SpringBootApplication(scanBasePackages={
		"controllers", "models", "repositories"})
@ComponentScan(basePackageClasses=UserController.class)
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}

}
