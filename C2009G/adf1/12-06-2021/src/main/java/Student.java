import java.util.Date;

public class Student implements IPlayable, ILearning{
    private String name;
    private Date dateOfBirth;
    //mot class thuc thi(implements) 1 hoac nhieu interfaces
    //bat buoc phai thuc thi cac phuong thuc trong Iplayable va ILearning

    @Override
    //Da implement inteface => bat buoc phai thuc thi cac phuogn thuc trong interface
    //interface co the giup ta chuan hoa cac phuogn thuc can thuc thi
    //VD: class LoginScreen, phuong thuc setupUI(), class WelcomeScreen cung co phuong thuc setupUI()
    //neu ko dung interface => ko thong nhat dat ten,eg: setupUserInterface(), setupGiaoDien(),,,
    //De thong nhat cach dat ten=> class LoginScreen implements I...
    //Ngoai ra interface con de thuc hien truyen data giua 2 man hinh
    public void buyABook(String bookName) {
        System.out.println(String.format("I buy book: %s", bookName));
    }

    @Override
    public void playFootball() {
        System.out.println("I play football");
    }

    @Override
    public void gotoLibrary() {
        System.out.println("I go to the library");
    }

    @Override
    public void playAGame(String gameName) {
        System.out.println(String.format("I play game: %s", gameName));
    }
}
