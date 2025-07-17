package com.aptech.myapp;

import com.aptech.myapp.interfaces.ICalculation;
import com.aptech.myapp.interfaces.ISomething;

public class Calculation implements ICalculation, ISomething {
    @Override
    public int sum(int x, int y) {
        return x + y;
    }

    @Override
    public int multiply(int x, int y, int z) {
        return x * y * z;
    }
}
