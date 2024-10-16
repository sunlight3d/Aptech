import models.Car;
import models.Point;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        int x, y;//primitive types
        x = 1;
        y = 2;
        //System.out.println("x = "+1+"y = "+y);
        System.out.println(String.format("x = %d, y = %d", x, y));
        Integer a = 123;
        System.out.println(String.format("a = %d, max int = %d", a,Integer.MAX_VALUE));
        System.out.println("max value of Float"+Float.MAX_VALUE);
        System.out.println("min value of Float"+Float.MIN_VALUE);
        System.out.println(Integer.valueOf("123"));;
        for(Integer i = 0; i < 100; i++) {
            System.out.println("i = "+i);
        }
        //Nhap du lieu tu ban phim
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter x11 = ");
//        Integer x11 = scanner.nextInt();
        //System.out.println(String.format("You entered: %d", x11));
        System.out.println(String.format("sum 2 and 3 is: %d", Calculation.sum(2,3)));
        System.out.println(String.format("multiply 2 and 3 is: %d", Calculation.multiply(2,3)));
        Long creditCard = 1234_5466_2256_7765L;
        Float z1 = 1_000_0000_000f;
        Double z2 = 1234_5678_9108.0;
        Margin direction = Margin.BOTTOM;
        System.out.println(direction);
        Car car1 = new Car();
        car1.setName("xx");
        car1.setColor("red");
        car1.setYear(2021);
        System.out.println("color of this car is : "+car1.getColor());
        car1.showInformation();
        System.out.println("car1 information: "+car1.toString());
        Point pointA = new Point(3.0, 2.0);
        Point pointB = new Point(1.0, 2.0);
        //tinh khoang cach giua 2 diem A, B ?
        //Double distance = Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
        System.out.println("distance = "+pointA.getDistance(pointA));
    }
}
