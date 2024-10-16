package org.example;

import org.example.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 docker run -d --name mysql-c1908iLeThanhNghi -e MYSQL_ROOT_PASSWORD=123456 -p 3308:3306 mysql:8.0.26
 mysql -h localhost -P 3308 -u root -p
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
        //jpaExample
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaExample");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Student studentA = entityManager.find(Student.class, Long.valueOf(1));
            System.out.println("haha");
        } catch (Exception e) {
            System.err.println("Error access JPA:"+e.toString());
        }
    }
}
