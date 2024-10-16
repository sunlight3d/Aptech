package package2;

import package1.Class1;

public class Class5 extends Class1 {
    public void doSomething(){
        super.prop1 = "haha";//neu prop1 = "default" => NO!, truong hop nay kho nho nhat
    }
}