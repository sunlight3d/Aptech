package com.exam.springde01.database;
import com.exam.springde01.models.Book;
import com.exam.springde01.models.Category;
import com.exam.springde01.models.User;
import com.exam.springde01.repositories.BookRepository;
import com.exam.springde01.repositories.CategoryRepository;
import com.exam.springde01.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Now connect with mysql using JPA
/*
docker run -d --rm --name mysql-spring-boot-tutorial \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_USER=hoangnd \
-e MYSQL_PASSWORD=123456 \
-e MYSQL_DATABASE=test_db \
-p 3309:3306 \
--volume mysql-spring-boot-tutorial-volume:/var/lib/mysql \
mysql:latest

mysql -h localhost -P 3309 --protocol=tcp -u hoangnd -p
* */
@Configuration
public class Database {
    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository,
                                   CategoryRepository categoryRepository,
                                   UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //fake users
                userRepository.save(new User("nva","123456"));
                categoryRepository.save(new Category("Programming"));
                categoryRepository.save(new Category("Stories"));
                Long categoryId = categoryRepository.findByCategoryName("Programming").getCategoryId();
                bookRepository.save(new Book("Java programming", 1234.5f, categoryId));
            }
        };
    }
}
