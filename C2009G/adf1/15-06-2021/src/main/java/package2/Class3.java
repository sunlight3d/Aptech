package package2;

import package1.Class1;

public class Class3 {
    public void doSomething(){
        //Neu class1 la "default" => class3 ko truy cap duoc vao class1
        Class1 object1 = new Class1();
        object1.prop1 = "haha";//prop1 = "default", "protected" => ko goi duoc, prop1 = "public" => goi duoc
    }
}
