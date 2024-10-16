import java.io.File;

public class App {
    public static void main(String args[]) {
        System.out.println("Hello");
//        FileManager fileManager = new FileManager("c:\\temp\\main.c");
//        fileManager.removeComments();
        FilmCrawl filmCrawl = new FilmCrawl();
        filmCrawl.getFilms();
    }
}
