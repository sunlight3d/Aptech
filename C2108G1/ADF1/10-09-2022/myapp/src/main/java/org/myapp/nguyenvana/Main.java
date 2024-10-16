package org.myapp.nguyenvana;

import org.myapp.nguyenvana.models.Result;

public class Main {

    public static void main(String[] args) {
        //Define an object from class
        Result result1 = new Result(8,9,10);
        result1.setMath(10);
        result1.setChemistry(5);
        System.out.println(result1.toString());
        //result1.showDetail();
        //Create a blank object, then set fields
        Result result2 = new Result();//default constructor / no-arguments constructor
        result2.setMath(5);
        result2.setPhysics(3);
        result2.setChemistry(9);

        Result result3 = result2;
        Result result4 = result2;
        Result result5 = result2;

        //free memory
//        result2 = null;
//        result3 = null;
//        result4 = null;
//        result5 = null;
//        System.out.println("alo");//Garbage collection
        Menu menu = new Menu();
        menu.showMenu();
    }
}