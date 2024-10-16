package models;

public class Car {
    //fields/ attributes => private
    private String name;
    private String color;
    private Integer year;
    //can cac ham setter de thay doi gia tri
    //Encapsulation
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }
    public void showInformation(){
        System.out.println(String.format("name = %s, color = %s, year = %d", name, color, year));
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
