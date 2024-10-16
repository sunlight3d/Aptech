package com.aptech.aprotrain;

public interface IStudent {
    //public int x; //interface cannot contain instance fields/properties
    public static float PI = 3.14f; //ok, interface can contain static fields/properties
    public void input();//methods in an interface cannot be "private", "protected"
    public void display();
}
