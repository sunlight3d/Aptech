import models.Product;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        System.out.println("Haha");
        SQLiteDB sqLiteDB = new SQLiteDB();
        List<Product> productList = sqLiteDB.getAllProducts();
        System.out.println("haha");
    }
}
