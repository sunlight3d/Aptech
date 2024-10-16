package com.member;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClubManager {
    private List<Member> members = new ArrayList<>();
    private String fileName = "member_of_club.txt";
    private static int NUMBER_OF_MEMBERS = 3;
    public void input() throws Exception{
        for(int i = 0; i < NUMBER_OF_MEMBERS; i++) {
            System.out.println("Enter information of member "+(i+1));
            Member member = new Member();
            member.input();
            members.add(member);
        }
    }
    public void writeToFile(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream
                    (new FileOutputStream(fileName));
            objectOutputStream.writeObject(members);
            objectOutputStream.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void readFromFile() {
        try {
            members.clear();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));

            //members = (ArrayList<Member>)objectInputStream.readObject();
            for(Member member: (ArrayList<Member>)objectInputStream.readObject()) {
                members.add(member);
            }
            System.out.println("The Object has been read from the file");
            objectInputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
