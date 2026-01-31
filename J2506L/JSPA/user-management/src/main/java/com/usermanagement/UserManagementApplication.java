package com.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		excludeName = {
				"org.springframework.boot.kotlinx.serialization.json.autoconfigure.KotlinxSerializationJsonAutoConfiguration"
		}
)
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

}
