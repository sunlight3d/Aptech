package package1;

public class Class2 {
    public void doSomething2() {
        //tront class2, truy cap vao "default" class1 => ok
        Class1 obj1 = new Class1();
        obj1.prop1 = "haha";//prop1 la protected, public, default => ok
    }
}