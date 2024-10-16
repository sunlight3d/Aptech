package com.de02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClubManager {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Member> members2 = new ArrayList<>();
    private InputStreamReader inputStreamReader;
    private String fileName = "member_of_club.txt";
    private BufferedReader bufferedReader;
    public void input() throws Exception {
        this.inputStreamReader = new InputStreamReader(System.in);
        this.bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Enter number of members: ");
        int numberOfMembers = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < numberOfMembers; i++) {
            Member member = new Member();
            member.input();
            members.add(member);
        }
    }
    public void writeToFile() throws Exception{
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(members);
        objectOut.close();
        System.out.println("The members object to file successfully");
    }
    public void readFromFile() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream(fileName));
        this.members2 = (ArrayList<Member>)objectInputStream.readObject();
        System.out.println("Load objects from file successfully");
        objectInputStream.close();
        for(Member member: members2) {
            System.out.println(member.toString());
        }
    }
}
