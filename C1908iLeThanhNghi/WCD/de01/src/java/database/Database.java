package database;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.*;
import java.util.ArrayList;
import models.*;
public class Database {
    private static final String CONNECTION_STRING = "jdbc:sqlserver://localhost\\SQLEXPRESS;DatabaseName=ExamSERVJSP";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";
    private Connection connection = null;
    public String sayHello(){
        return "hahahaa";
    }
    private static Database instance;
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();                    
        }
        return instance;
    }
    public Connection getConnection(){
        try {             
            //ExamSERVJSP
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            if (connection != null) {
                DatabaseMetaData dm = (DatabaseMetaData) this.connection.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
            return this.connection; 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } 
    }
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        try {   
            this.getConnection();            
            Statement statement = (Statement) this.connection.createStatement();
            String sql = "SELECT * FROM tblProduct";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String productName = resultSet.getString("productName");
                Float price = resultSet.getFloat("price");
                Integer quantity = resultSet.getInt("quantity");
                Product product = new Product(id, productName, price, quantity);
                products.add(product);
            }
            
        } catch(SQLException ex) {
            System.err.println("Error in SQL: "+ex.toString());
        } finally {
            return products;
        }                
    }
    public void insertProduct(Product product) {        
        try {   
            this.getConnection();            
            String sql = "INSERT INTO tblProduct(id, productName, price, quantity) VALUES(?, ?, ?, ?)";
            PreparedStatement  statement = (PreparedStatement) this.connection.prepareStatement(sql);           
            statement.setInt(1, product.getId());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.executeUpdate();                        
            System.out.println("insert data successfully");
        } catch(SQLException ex) {
            System.err.println("Error in SQL: "+ex.toString());
        }                
    }
    public void deleteProduct(int productId) {        
        try {   
            this.getConnection();            
            String sql = "DELETE FROM tblProduct WHERE id = ?";
            PreparedStatement  statement = (PreparedStatement) this.connection.prepareStatement(sql);           
            statement.setInt(1, productId);            
            statement.executeUpdate();                        
            System.out.println("delete data successfully");
        } catch(SQLException ex) {
            System.err.println("Delete error: "+ex.toString());
        }                
    }
    
}