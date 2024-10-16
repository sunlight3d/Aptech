package com.product;

import com.product.books.Book;
import com.product.computers.Computer;

import java.util.*;

public class ProductManagement {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> products = new ArrayList<>();
    public void inputProducts(ProductType productType) {
        if(productType == ProductType.BOOK) {
            System.out.println("Enter number of books: ");
            int numberOfBooks = this.scanner.nextInt();
            for(int i = 0; i < numberOfBooks; i++){
                Book newBook = new Book();
                newBook.input();
                this.products.add(newBook);
            }
        }else if(productType == ProductType.COMPUTER) {
            System.out.println("Enter number of computers: ");
            int numberOfComputers = this.scanner.nextInt();
            for (int i = 0; i < numberOfComputers; i++) {
                Computer newComputer = new Computer();
                newComputer.input();
                this.products.add(newComputer);
            }
        }
    }
    public void displayComputers() {
        /*
        Collections.sort(this.products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return (int) (product1.price - product2.price);
            }
        });

         */
        Collections.sort(this.products, (Product product1, Product product2)->
                (int) (product1.price - product2.price));
        for (Product eachProduct: this.products) {
            if(eachProduct instanceof Computer) {
                ((Computer)eachProduct).display();
            }
        }
    }
    public void displayBooks() {
        Collections.sort(this.products, (Product product1, Product product2)->
                (int) (product1.productName.compareTo(product2.productName)));
        for (Product eachProduct: this.products) {
            if(eachProduct instanceof Computer) {
                ((Computer)eachProduct).display();
            }
        }
    }
}
