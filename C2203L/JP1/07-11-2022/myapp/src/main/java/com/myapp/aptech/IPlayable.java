package com.myapp.aptech;

public interface IPlayable {
    //we learn "interface" in Java
    //interace cannot be "private", "protected"
    //"access modifier" of an interface cannot be "private", "protected"
    public void playFootball();//interface only contains "prototype"
    //int x;//interface does not contain "property"
    public static String NAME = "Hoang";//ok, but can contain "static properties"
}
