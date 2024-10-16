package com.myapp.aptech;
public class Student
        implements IPlayable, ILearning
        //a class can implement many interfaces
{
    //A class "implements" an interface => that class implements all methods in that interface
    private String name;

    @Override//annotations

    public void playFootball() {
        System.out.println("Di choi bong da");
    }

    @Override
    @Deprecated(since = "version 12.0")
    @SuppressWarnings(" please use borrowABook instead")
    public void borrowABook(String bookName) {
        System.out.println("I am borrowing book: "+bookName);
    }
}
