package myapp.MyApp;

import learninterface.ILearning;
import learninterface.IPlayable;
import myapp.MyApp.models.InformationDisplay;
import myapp.MyApp.models.Person;

public class Main {   
    public static void main(String[] args) {
        /*
        InformationDisplay informationDisplay = new InformationDisplay();
        informationDisplay.input();
        */
        //doi tuong person co cac method phuc vu viec: hoc + an choi
        //Person personA = new Person();
        ILearning personA = new Person();
        //personA.playFootball();
        //personA.playGame("pikachu");

        personA.gotoSchool();
        personA.borrowBook("Java programming");
        //Goi thuoc tinh static cua interface
        System.out.println(IPlayable.x);//YES
        IPlayable objectA = new IPlayable() {
            @Override
            public void playFootball() {

            }

            @Override
            public void playGame(String gameName) {

            }
        };
    }
    
}
