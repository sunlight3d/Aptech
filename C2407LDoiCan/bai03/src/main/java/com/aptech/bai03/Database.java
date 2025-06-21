package com.aptech.bai03;


public class Database {
    private static Database instance;

    private Database(){
        //prevent user to create an object directly

    }
    //get singleton object
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
