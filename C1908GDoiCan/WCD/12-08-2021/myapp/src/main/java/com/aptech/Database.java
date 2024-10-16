/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;
/**
 docker run -d --name mysql-c1908GDoiCan --volume mysql-c1908GDoiCan:/var/lib/mysql -p 3309:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql
 mysql -P 3309 --protocol=tcp -u root -p
 create database c1908GDoiCan;
 use c1908GDoiCan;
 CREATE TABLE tblCategory(
   id integer auto_increment primary key,
   name varchar(300) not null,
   description text
 );
 CREATE TABLE tblProduct(
   id integer auto_increment primary key,
   name varchar(300) not null,
   description text,
   price double default 0.0,
   categoryId int
 );
 
ALTER TABLE tblProduct
ADD CONSTRAINT FK_ProductCategory
FOREIGN KEY (categoryId) REFERENCES tblCategory(id);
* 
insert into tblCategory(name, description)
values('Beverages',	'Soft drinks coffees, teas, beers, and ales'),
('Condiments','Sweet and savory sauces, relishes, spreads, and seasonings'),
('Confections',	'Desserts, candies, and sweet breads'),
('Dairy', 'Products Cheeses'),
('Grains','Cereals, Breads, crackers, pasta, and cereal');

insert into tblProduct(name, description, price, categoryId)
values('product aa', 'this is AA', 123, 1),
('product bb', 'this is BB', 222, 1),
('product cc', 'this is CC', 333, 2),
('product dd', 'this is DD', 444, 2),
('product ee', 'this is EE', 555, 2);
* 
* 
* ;
* 
 */
import com.aptech.models.Category;
import com.aptech.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//co the thay bang JPA
public class Database {
    //singleton object
    private static Database instance;
    private Database() {}
    
    public static Database GetInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
    private final String connectionString = "jdbc:mysql://localhost:3309/c1908GDoiCan?user=root&password=123456";
    public Connection getConnection() {
        Connection connection = null;
        try 
        {            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionString);
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());                
        }
        return connection;
    }
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<Category>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = this.getConnection().createStatement();
            rs = stmt.executeQuery("select * from tblCategory");            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                //create Category object from id, name, desc
                Category category = new Category(id, name, description);
                categories.add(category);
            }
        }
        catch (SQLException ex){            
            System.out.println("SQLException: " + ex.getMessage());            
        }
        
        return categories;
    }
    
    //chua test 
    public List<Product> getProductsFromGategoryId(int categoryId) {
        List<Product> products = new ArrayList<Product>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.getConnection().createStatement();
            resultSet = statement.executeQuery(String.format("select * from tblProduct where categoryId = %d", categoryId));            
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");                
                Product product = new Product(id, name, description, price);
                products.add(product);
            }
        }
        catch (SQLException ex){            
            System.out.println("SQLException: " + ex.getMessage());            
        }        
        return products;
    }
    public Category getCategoryFromName(String categoryName) {
        Category category = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.getConnection().createStatement();
            String sql = String.format("select * from tblCategory where tblCategory.name = \'%s\'", categoryName);
            resultSet = statement.executeQuery(sql);            
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");                
                String description = resultSet.getString("description");     
                category = new Category(id, name, description);                
            }
        }
        catch (SQLException ex){            
            System.out.println("SQLException: " + ex.getMessage());            
        }        
        return category;
    }
    
    public void updateProduct(int productId, int categoryId) {
        //farmer
        //dung JPA tot hon
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "update tblProduct set categoryId = ? where tblProduct.id = ?";
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, categoryId);
            statement.setInt(2, productId);
            //buoi sau lam tiep
            resultSet = statement.executeQuery(String.format("select * from tblProduct where categoryId = %d", categoryId));            
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");                
                Product product = new Product(id, name, description, price);                
            }
        }
        catch (SQLException ex){            
            System.out.println("SQLException: " + ex.getMessage());            
        }   
        
    }
}
