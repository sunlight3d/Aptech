package models;

public class Rectangle extends Shape{
    //Viet them thuoc tinh cho lop cha
    private Float width;
    private Float height;
    public Rectangle(String color, String name, Float width, Float height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }
    //ham thong thuong
    public void funcB() {
        //goi den funcB cua lop cha
        super.funcA();//call duoc neu funcA la public, default, protected
        System.out.println("day la funcB");
    }
    //tinh dien tich
    @Override
    public Float getArea() {
        return width * height;
    }
    //tinh chu vi

    @Override
    public Float getPerimeter() {
        return 2 * (width + height);
    }
}
