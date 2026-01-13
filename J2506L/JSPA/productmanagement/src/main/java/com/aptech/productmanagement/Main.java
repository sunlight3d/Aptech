package com.aptech.productmanagement;

import com.aptech.productmanagement.models.ElectronicProduct;
import com.aptech.productmanagement.models.FoodProduct;
import com.aptech.productmanagement.models.Product;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int choice = -1;
        ArrayList<Product> products = new ArrayList<>();
        //mock
        /*
        products.add(new ElectronicProduct("1", "iPhonE X", 123.0, 2, "Apple"));
        products.add(new FoodProduct("4", "nem hai san", 111, "12-12-2028", 2.5));
        products.add(new FoodProduct("4", "nem hai san", 111, "12-12-2028", 2.5));
        products.add(new ElectronicProduct("2", "iPhonE 16", 223.0, 12, "Apple"));
        */
        products.add(new ElectronicProduct("1", "iPhonE X", 123.0, 2, "Apple"));
        FoodProduct productX = new FoodProduct("4", "nem hai san", 111, "12-12-2028", 2.5);
        products.add(productX);
        //products.add(productX);
        products.add(new ElectronicProduct("2", "iPhonE 16", 223.0, 12, "Apple"));
        System.out.println("""
                1. Thêm sản phẩm điện tử
                2. Thêm sản phẩm thực phẩm
                3. Hiển thị toàn bộ sản phẩm
                4. Tìm sản phẩm theo tên
                5. Cập nhật sản phẩm theo ID
                6. Xóa sản phẩm theo ID
                7. Sản phẩm giá cao nhất
                8. Sản phẩm giá thấp nhất
                9. Tổng giá trị kho hàng                
                0. Thoát"""); //Nhớ nói kỹ thêm về đếm số sản phẩm điện tử và số thực phẩm
        while (choice != 0) {
            System.out.println("Enter your choice(0-9): ");
            /*
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
             */
            choice = (new Scanner(System.in)).nextInt();
            /*
            if(choice == 1) {
                System.out.println("you choose 1");
            } else if(choice == 2) {
                System.out.println("you choose 2");
            } else if(choice == 3) {
                System.out.println("you choose 3");
            } else if(choice == 4) {
                System.out.println("you choose 3");
            }  else if(choice == 5) {
                System.out.println("you choose 5");
            }  else if(choice == 6) {
                System.out.println("you choose 6");
            }  else if(choice == 7) {
                System.out.println("you choose 7");
            }  else if(choice == 8) {
                System.out.println("you choose 8");
            }  else if(choice == 9) {
                System.out.println("you choose 9");
            } else {
                System.err.println("You must choose 0-9");
            }
            */
            switch (choice) {
                case 1: {
                    System.out.println("Enter number of electric products : ");
                    int numberOfProducts = (new Scanner(System.in)).nextInt();
                    for(int i = 0; i < numberOfProducts; i++){
                        ElectronicProduct electronicProduct = new ElectronicProduct();
                        electronicProduct.input();
                        products.add(electronicProduct);
                    }
                    break;
                }

                case 2: {
                    System.out.println("Enter number of food products : ");
                    int numberOfProducts = (new Scanner(System.in)).nextInt();
                    for(int i = 0; i < numberOfProducts; i++){
                        FoodProduct foodProduct = new FoodProduct();
                        foodProduct.input();
                        products.add(foodProduct);
                    }
                    break;
                }
                case 3: {
                    //System.out.println("You choose 3");
                    for(Product eachProduct: products) {
                        System.out.println(eachProduct);
                    }
                    break;
                }

                case 4: {
                    //System.out.println("You choose 4");
                    System.out.println("Enter name to search: ");
                    String filteredText = (new Scanner(System.in)).next();
                    ArrayList<Product> filteredProducts = new ArrayList<>();
                    for(Product product: products) {
                        if(product.getName().toLowerCase().contains(filteredText.trim().toLowerCase())) {
                            filteredProducts.add(product);
                        }
                    }
                    if(filteredProducts.isEmpty()) {
                        System.err.println("Cannot find products");
                    }
                    for(Product eachProduct: filteredProducts) {
                        System.out.println(eachProduct);
                    }
                    break;
                }

                case 5:
                    System.out.println("Which product to update(id): ");
                    String id = (new Scanner(System.in)).next().trim();
                    Product selectedProduct = null;
                    for(Product product: products) {
                        if(product.getId().equals(id)) {
                            selectedProduct = product;
                            break;
                        }
                    }
                    if(selectedProduct == null) {
                        System.err.println("Cannot find product to update !");
                    } else {
                        System.out.println(selectedProduct);
                        selectedProduct.update();
                    }
                    break;
                case 6:
                    System.out.println("You choose 6");
                    break;
                case 7:
                    System.out.println("You choose 7");
                    break;
                case 8:
                    System.out.println("You choose 8");
                    break;
                case 9:
                    System.out.println("You choose 9");
                    break;
                case 0:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.err.println("You must choose 0-9");
            }
        }
    }
}