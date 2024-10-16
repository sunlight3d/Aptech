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

        FilmCrawl filmCrawl = new FilmCrawl();
        filmCrawl.getFilmsFromWebsite();
        MongoDB.getInstance().saveFilms(filmCrawl.getFilmList());
        /*
        Set<Node> expression = new HashSet<Node>();
        Node nodeA = new Node("5");
        Node nodeB = new Node("6");
        Node nodeC = new Node("7");
        Node nodeD = new Node("8");
        Node node1 = new Node("*");
        nodeA.setParent(node1);
        nodeB.setParent(node1);
        Node node2 = new Node("/");
        nodeC.setParent(node2);
        nodeD.setParent(node2);
        Node node3 = new Node("-");
        node1.setParent(node3);
        node2.setParent(node3);
        */
    }
}
