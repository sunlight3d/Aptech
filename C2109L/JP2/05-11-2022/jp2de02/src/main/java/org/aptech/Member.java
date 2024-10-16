package org.aptech;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.regex.Pattern;

public class Member implements Serializable {
    private String memberID;
    private String memberName;
    private String address;

    public Member() {

    }

    public Member(String memberID, String memberName, String address) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.address = address;
    }
    public void input() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter member's id");
            String memberID = bufferedReader.readLine();
            boolean isValidMemberID = Pattern.compile("(^T|V|A)(MB|MT|MN)[0-9]+")
                                        .matcher(memberID).matches();
            if(isValidMemberID) {
                this.memberID = memberID;
                break;
            }
        }
        System.out.println("Enter member's name: ");
        this.memberName = bufferedReader.readLine();
        System.out.println("Enter member's address: ");
        this.address = bufferedReader.readLine();

    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", memberName='" + memberName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
