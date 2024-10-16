import models.MongoDB;
import models.Node;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String args[]) {
        System.out.println("Hello");
//        FileManager fileManager = new FileManager("c:\\temp\\main.c");
//        fileManager.removeComments();

//        FilmCrawl filmCrawl = new FilmCrawl();
//        filmCrawl.getFilmsFromWebsite();
//        MongoDB.getInstance().saveFilms(filmCrawl.getFilmList());
        MongoDB.getInstance().getAllFilms();
    }
}
