import models.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteDB {
    private Connection connection;
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from product");
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("year")
                ));
            }
        }catch (Exception exception) {
            System.err.println("exception = "+exception.toString());
        } finally {
            return  products;
        }

    }
    public Connection getConnection() {
        try
        {
            // create a database connection
            //            statement.executeUpdate("drop table if exists person");
            //statement.executeUpdate("create table person (id integer, name string)");
            //statement.executeUpdate("insert into person values(1, 'leo')");
            //statement.executeUpdate("insert into person values(2, 'yui')");
            connection = DriverManager.getConnection("jdbc:sqlite:sample.sqlite");
            System.out.println("connect successful");
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            return connection;
        }
    }
}
