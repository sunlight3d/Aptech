package org.myapp.nguyenvana.models;

import java.util.Calendar;

public class Student  {
    public Student() {}
    //encapsulation:
    //fieds are "private", method should be "public"
    private String name;
    private String province;
    private int birthYear;
    private Result mark;

    public String getName() {
        return name;
    }

    public Student(String name, String province,
                   int birthYear, Result mark) {
        this.name = name;
        this.province = province;
        this.birthYear = birthYear;
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getBirthYear() {
        return birthYear;
    }
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    public Result getMark() {
        return mark;
    }

    public void setMark(Result mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student's detail: \n" +
                "name : " + name + "\n" +
                "province : " + province + "\n" +
                "birthYear : " + birthYear + "\n" +
                "age : " + this.getAge() + "\n" +
                "mark : " + mark + "\n";
    }
}
