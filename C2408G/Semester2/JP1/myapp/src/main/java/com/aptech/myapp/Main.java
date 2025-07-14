package com.aptech.myapp;

import com.aptech.myapp.models.Customer;
import com.aptech.myapp.models.Point;
import com.aptech.myapp.models.Product;

import java.util.ArrayList;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String BASE_URL = "http://localhost:3000";
    public static void main(String[] args) {
        //bai04();
        Product product = new Product();
        //product.name
    }


    public static void bai04() {
        int[] someNumbers = new int[4];
        someNumbers[0] = 7;
        someNumbers[1] = 8;
        someNumbers[2] = 10;
        someNumbers[3] = 9;
        //someNumbers[10] = 100;
        //System.out.println(someNumbers[5]);
        System.out.println("haha");
        float[] someFloats = {};
        //someFloats[0] = 100;
        int sum = 0;
        final int MATRIX_SIZE = 10;
        double[][] someDoubles = new double[MATRIX_SIZE][MATRIX_SIZE];
        for(int i = 0; i < someDoubles.length; i++) {
            for(int j = 0; j < someDoubles.length; j++) {
                sum += 1;
                //someDoubles[i][j] = sum;
                //someDoubles[i][j] = i + j;
                someDoubles[i][j] = (i == ((MATRIX_SIZE -1 -j)) || (i == j)) ? 1 : 0;

            }
        }
        System.out.println("Ouput: ");
        for(int i = 0; i < someDoubles.length; i++) {
            System.out.println();
            for(int j = 0; j < someDoubles.length; j++) {
                //System.out.printf("Item[%d, %d] = %d \n", i, j, (int)someDoubles[i][j]);
                //System.out.printf("%d ", (int)someDoubles[i][j]);
                System.out.printf("%d%d  ", i,j);
            }
        }
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1,3));
        points.add(new Point(2,7));
        points.add(new Point(4,8));
        points.add(new Point(7,9));
        /*
        for(int i = 0; i < points.size(); i++) {
            System.out.println(points.get(i));
        }*/
        /*
        for(Point point: points){
            System.out.println(point);
        }
         */
        points.forEach((Point point) -> {
            System.out.println(point);
        });
    }
    public static void bai03() {
        Customer customerA = new Customer();//default constructor
        //customerA.name = "Nguyen Van A";//private
        /*
        customerA.setName("Nguyen Van A");
        customerA.setAge(18);
        customerA.setAddress("Nha a ngo b");
        */
        Customer customerB = new Customer(2,"Nguyen Van B", 20, "nha x ngo y");
        Customer customerX = customerB;
        customerB.setName("nguyen van x");
        //customerX.getName() => nguyen van x
        System.out.println(customerB);
        /*
        Builder pattern su dung Lombok
        Customer customerC = Customer.builder()
                                     .id(3)
                                    .address("nha a ngo bcee")
                                     .name("Nguyen Van C")
                                     .build();
         */


        //...
        //all arguments constructor
    }
    public static void bai01() {
        int x = 1;
        int y = 2;
        int sum = x + y;
        System.out.println(sum);
        //strint concatenation
        System.out.printf("sum = %d, x = %d, y = %d \n",sum, x, y);
        int numberOfStudents = 100;
        //int number_of_students = 100; //NO!
        long MY_CREDIT_CARD = 1234_5678_9101_1214L;
        System.out.println("chao ban");

        //reference type
        Person personA = new Person();
        personA.name = "Nguyen Van A";
        Person personB = personA;//reference type
        personA.name = "Nguyen Van B";
        System.out.println(personB.name);

        Person personX = new Person();
        personX.name = "Nguyen Van X";

        //primitive type
        Integer a = 10;
        Integer b = a;//assignment
        a = 20;
        //b = ?
        System.out.println(b);
        //personB.name = ?
    }
}