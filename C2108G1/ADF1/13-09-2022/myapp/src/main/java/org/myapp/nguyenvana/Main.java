package org.myapp.nguyenvana;

import org.myapp.nguyenvana.models.Result;

import javax.imageio.event.IIOReadProgressListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //primitive variable, example: int, float
        int a1 = 2;
        float a2 = a1;//automatically casting = implicit
        //explicit casting
        int a3 = (int)a2;
        //lost information
        float b1 = 1234_5678_9101_1121_2222f;
        int a4 = (int)b1;
        int x1 = 100;
        int x2 = x1;//assign = clone
        //int is "value data type" or "primitive"
        x1 = 200;
        //x2 = ?
        //Define an object from class
        Result result1 = new Result(8,9,10);
        Result result10 = result1;//reference
        //How to clone result1 to ... result11
        //basic way
        Result result11 = new Result(result1.getMath(), result1.getPhysics(), result1.getChemistry());
        result1.setMath(1);
        //clone using "static method"
        Result result12 = Result.cloneFrom(result1);
        result1.setMath(10);
        result1.setChemistry(5);
        long cardNumber = 1235_2369_1122_1236L;
        //clone using "instance method", NOT GOOD
        Result result13 = (new Result()).cloneFrom1(result1);//NOT GOOD, but run !

        //ArrayList as a "reference type"
        ArrayList<String> someNames = new ArrayList<>();
        someNames.add("Anna");
        someNames.add("John");
        someNames.add("Henry");
        someNames.add("Tien");
        ArrayList<String> someNames2 = someNames;
        someNames2.set(1, "Kaka");
        //someNames ?

        //final = cannot be re-assigned
        final Result result15 = new Result(1,2,3);
        //result15 = new Result(4,4,4);//cannot be re-assigned
        result15.setPhysics(10); //ok, but field can be changed(mutable)
        //clone using Cloneable interface...
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