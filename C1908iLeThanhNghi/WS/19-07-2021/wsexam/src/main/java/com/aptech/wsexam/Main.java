package com.aptech.wsexam;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class Main {
	public static void main(String [] args) {
		Configuration configuration = new Configuration().configure("hibernate");
		//SessionFactory sessionFactory = configuration.buildSessionFactory();
		
	}
}
