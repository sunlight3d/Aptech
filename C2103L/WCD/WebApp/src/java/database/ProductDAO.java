package database;

/*
 * To change this license header, choose License Headers in Project Properties.
*/
import models.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    
    //private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    private static final String DB_URL = "jdbc:mysql://localhost:3316/c2103l";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public List<Product> getProductsByName(String name) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Product> productList = new ArrayList<>();

    try {
        // Bước 1: Đăng ký JDBC driver
        Class.forName(JDBC_DRIVER);

        // Bước 2: Mở kết nối
        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        // Bước 3: Chuẩn bị câu truy vấn
        String query = "SELECT * FROM Product WHERE product_name LIKE ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, "%" + name + "%");

        // Bước 4: Thực thi câu truy vấn
        rs = stmt.executeQuery();

        // Bước 5: Xử lý kết quả
        while (rs.next()) {
            int id = rs.getInt("id");
            String productName = rs.getString("product_name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");

            Product product = new Product(id, productName, price, quantity);
            productList.add(product);
        }

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        // Bước 6: Đóng kết nối và giải phóng tài nguyên
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        return productList;
    }
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();                
        try {             
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");

                Product product = new Product(id, productName, price, quantity);
                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }


    // Các phương thức CRUD khác (create, update, delete) có cùng cấu trúc với phương thức getProductByName()
    // Bạn có thể triển khai các phương thức này tương tự như getProductByName()

    // Ví dụ phương thức create
    public void createProduct(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Bước 1: Đăng ký JDBC driver
            Class.forName(JDBC_DRIVER);

            // Bước 2: Mở kết nối
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Bước 3: Chuẩn bị câu truy vấn
            String query = "INSERT INTO Product (product_name, price, quantity) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());

            // Bước 4: Thực thi câu truy vấn
            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Bước 5: Đóng kết nối và giải phóng tài nguyên
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}