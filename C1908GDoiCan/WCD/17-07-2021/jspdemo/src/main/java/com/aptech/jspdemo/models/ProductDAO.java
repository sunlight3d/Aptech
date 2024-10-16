package com.aptech.jspdemo.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
create table tblProduct(
	id integer auto_increment primary key,
	name varchar(300),
	year integer
);
insert into tblProduct(name, year) values("iphone 6", 2016);
 * */
public class ProductDAO {
	//truy cap xuong DAtabase va lay du lieu
	private final String CONNECTION_STRING = "jdbc:mysql://localhost:3308/testdb";
	private final String USERNAME = "root";
	private final String PASSWORD = "123456";
			
	public Product getProduct(Integer id) {
		//truy cap DB
		Product newProduct = new Product();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					CONNECTION_STRING, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			String sql = String.format("select * from tblProduct where id=%d", id);
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				newProduct.setId(resultSet.getInt("id"));;
				newProduct.setName(resultSet.getString("name"));;
				newProduct.setYear(resultSet.getInt("year"));;
			}
			
		}catch(Exception e) {
			System.err.println("Cannot get Product, detail: "+e.toString());
		} finally {
			return newProduct;
		}
		
	} 
}
