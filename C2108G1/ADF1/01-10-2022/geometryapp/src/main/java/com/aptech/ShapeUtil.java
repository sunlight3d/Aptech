package com.aptech;

import java.util.ArrayList;

public class ShapeUtil {
    public static void printInfo(ArrayList<GeometricObject> shapes) {
        for (GeometricObject eachShape: shapes) {
            System.out.println(eachShape.getInfo());
        }
    }
}
