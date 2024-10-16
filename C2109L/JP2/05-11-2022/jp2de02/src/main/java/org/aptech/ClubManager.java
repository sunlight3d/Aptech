package org.aptech;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ClubManager {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Member> outputMembers = new ArrayList<>();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String outputFile = "member_of_club.txt";
    public void inputMembers() {
        try {
            System.out.println("Enter number of members: ");
            int numberOfMembers = Integer.valueOf(bufferedReader.readLine().trim());
            for(int i = 0; i < numberOfMembers; i++) {
                System.out.println("Enter student's info of student "+(i+1));
                Member member = new Member();
                member.input();
                members.add(member);
            }
            System.out.println("haha");
        }catch (Exception e) {
            System.err.println("Cannot input members, error: "+e.getMessage());
        }
    }
    public void saveToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFile));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write objects to file
            /*
            members.forEach((Member member) -> {
               //objectOutputStream.writeObject(member);
                System.out.println("where Am I ?");
            });
             */
            for(Member member: members) {
                objectOutputStream.writeObject(member);
            }
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Cannot read/write file");
        }
    }
    public void readFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(outputFile));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            outputMembers.clear();
            while (true) {
                try {
                    Member member = (Member)objectInputStream.readObject();
                    outputMembers.add(member);
                }catch (IOException e){
                    break;
                }
            }
            objectInputStream.close();
            fileInputStream.close();
            outputMembers.forEach((member -> {
                System.out.println(member);
            }));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Cannot read/write file");
        }
    }
}
