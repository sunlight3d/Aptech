package org.myapp.nguyenvana;

import org.myapp.nguyenvana.models.Result;

public class Main {

    public static void main(String[] args) {
        //Define an object from class
        Result result1 = new Result(8,9,10);
        //result1.showDetail();
        System.out.println(result1.toString());
    }
}