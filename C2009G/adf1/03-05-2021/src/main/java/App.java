import controllers.CDController;
import models.CompactDisk;
import models.Food;

import java.text.SimpleDateFormat;

public class App {
    public static void main(String [] args) {
        System.out.println("hello");
        //Thu tao ra cac doi tuong food
        //string: 32/12/2021 => Date
        //new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998")
        /*
        Food food1 = new Food(1, "sushi", 12.3f,
                Helper.convertStringToDate("31/05/2021"),
                Helper.convertStringToDate("01/06/2021"));
        Food food2 = new Food(1, null, -123.4f,
                Helper.convertStringToDate("31/05/2021"),
                Helper.convertStringToDate("29/05/2021"));
        System.out.println("haha");
         */
        //fake
        CompactDisk cd1 = new CompactDisk(1, "bai hat A", "ca si A", 3, 111.0f);
        CompactDisk cd2 = new CompactDisk(2, "bai hat B", "ca si B", 4, 222.0f);
        CompactDisk cd3 = new CompactDisk(3, "bai hat C", "ca si C", 5, 333.0f);
        CompactDisk cd4 = new CompactDisk(4, "bai hat D", "ca si D", 6, 444.0f);
        CompactDisk cd5 = new CompactDisk(1, "bai hat D", "ca si E", 7, 555.0f);
        CDController cdController = new CDController();
        cdController.insert(cd1);
        cdController.insert(cd3);
        cdController.insert(cd2);
        //cdController.insert(cd5);
        cdController.printAllCDs();
        cdController.sortByPrice();
        System.out.println("After sort: ");
        cdController.printAllCDs();
        cdController.sortByTitle();
        System.out.println("After sort: ");
        cdController.printAllCDs();

    }
}
