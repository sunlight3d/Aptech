package models;

public class Circle extends Shape{
    private Float radius;
    @Override
    //Polimophism
    public Float getArea() {
        return (float)Math.PI * radius * radius;
    }

    @Override
    public Float getPerimeter() {
        return (float)Math.PI * 2 * radius;
    }
}
