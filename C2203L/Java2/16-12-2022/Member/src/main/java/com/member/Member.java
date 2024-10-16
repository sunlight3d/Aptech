package com.member;

import java.io.Serializable;
import java.io.Serializable;
import java.util.regex.Pattern;

import static com.member.Helper.inputString;

//^[T|V|A]{1}(MB|MT|MN)[\d]+$
public class Member implements Serializable {
    private String memberID;
    private String memberName;
    private String address;

    public Member() {}
    public Member(String memberID, String memberName, String address) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.address = address;
    }
    public void input() throws Exception{
        try {
            //validate here
            while(!Pattern.compile("^[T|V|A]{1}(MB|MT|MN)[\\d]+$")
                    .matcher(this.memberID).matches()) {
                this.memberID = inputString("Enter memberID");
            };
            this.memberName = inputString("Enter memberName");
            this.address = inputString("Enter address");
        }catch (Exception e) {
            throw new Exception("Cannot input student's information"+e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", memberName='" + memberName + '\'' +
                ", address='" + address + '\'' +
                '}';
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
}
