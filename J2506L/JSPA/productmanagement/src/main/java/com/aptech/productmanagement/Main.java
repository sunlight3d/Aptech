package com.aptech.productmanagement;

import com.aptech.productmanagement.models.ElectronicProduct;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int choice = -1;
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

                    }
                    break;
                }

                case 2:
                    System.out.println("You choose 2");
                    break;
                case 3:
                    System.out.println("You choose 3");
                    break;
                case 4:
                    System.out.println("You choose 4");
                    break;
                case 5:
                    System.out.println("You choose 5");
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