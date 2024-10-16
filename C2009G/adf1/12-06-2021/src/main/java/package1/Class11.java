package package1;

public class Class11 extends Class1{
    public void doSomething1() {
        super.prop1 = "aa";//prop1 = "public", "default", protected => ok, private => NO!
    }
}
