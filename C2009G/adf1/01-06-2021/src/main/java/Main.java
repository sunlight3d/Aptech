import models.Account;
import models.Rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        //Rectangle rectangle1 = new Rectangle();
//        rectangle1.setWidth(100.0f);//lat nua se nhap tu ban phim
//        rectangle1.setHeight(200.0f);
        //Nau muon nhap tu ban phim thi lam the nao ?
//       Rectangle rectangle1 = Rectangle.input();
        //System.out.println("Area of this rectangle : "+rectangle1.getArea());
//        System.out.println(String.format("Area of this rectangle : %.1f",rectangle1.getArea()));
        Account account = new Account(12345L,"nguyen van A");
        System.out.println(account.toString());
        account.widthdraw(20.0f);
        System.out.println(account.toString());
        account.deposit(10.0f);
        System.out.println(account.toString());
        Account account2 = new Account(12567L,"nguyen van B");
        account.transferTo(account2, 30.0f);
        System.out.println(account.toString());
        System.out.println(account2.toString());
    }
}
