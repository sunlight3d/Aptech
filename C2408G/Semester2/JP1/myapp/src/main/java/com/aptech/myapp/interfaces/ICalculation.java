package com.aptech.myapp.interfaces;

public interface ICalculation {
    int sum(int x, int y);
    int multiply(int x, int y, int z);
    /*
    public int multiply(int x, int y, int z) {
        return 0; //error
    }
     */
    //int a; //error
    //public float PI = 3.14f; //ok
    public static float PI = 3.14f;
    public static void doSomething() {
        System.out.println("haha");//ok
    }
    //public static void abc();//error
}
