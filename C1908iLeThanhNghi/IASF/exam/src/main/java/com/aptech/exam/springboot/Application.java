package com.aptech.exam.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/*
install mysql in Docker:
docker search mysql
docker pull mysql
docker run -d --publish=3307:3306 --name=mysql -e MYSQL_ROOT_PASSWORD=root mysql
docker images
docker exec -it 3282b338b6fc bash
mysql -u root -p

* */
//@SpringBootApplication(scanBasePackages = "com.baeldung.boot.jsp")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
