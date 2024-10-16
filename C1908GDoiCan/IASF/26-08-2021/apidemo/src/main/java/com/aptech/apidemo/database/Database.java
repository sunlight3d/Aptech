package com.aptech.apidemo.database;

import com.aptech.apidemo.models.User;
import com.aptech.apidemo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository){
        //Dependency injection
        //tra ve 1 function thuc thi interface CommandLine Runner
        return (args) -> {
            User mrA = new User("nva@gmail.com", "nguyen van A", "123456789");
            User mrB = new User("nvb@gmail.com", "nguyen van B", "222233332");
            logger.info("Insert data: "+userRepository.save(mrA));
            logger.info("Insert data: "+userRepository.save(mrB));
        };
    }
}
