using System;
using practice1.models;
using practice1.namespace1;
using practice1.namespace2;
//https://docs.microsoft.com/en-us/dotnet/csharp/tour-of-csharp/program-building-blocks
namespace practice1
{
    class MyBox {
        public int Value;
    }
    class Program
    {
        public static void doSomething(MyBox myBox) {

            myBox.Value = 120;
            Console.WriteLine("heh");
        }
        //ten phuong thuc => viet Hoa
        //.NET 5.0 = .NET + .NET Core
        static void Main(string[] args)
        {
            Result resultOfStudentA = new Result()
            {
                Math = 0,
                Physics = 5,
                Chemistry = 6
            };
            Student studentA = new Student()
            {
                Name = "Hoang",
                BirthYear = 1990,
                Province = "Hanoi",//thu tu ko quan trong
                //co 10 thuoc tinh, khoi tao 3 => ok => Builder Pattern
                Result = resultOfStudentA,                
            };
            Console.WriteLine("+------------------------------------------------------------------+");;
            Console.WriteLine("| STUDENT EXAM RESULT MANAGEMENT PROGRAM |");
            Console.WriteLine("+ ------------------------------------------------------------------+");
            Console.WriteLine("| 1.Input | 2.Sort | 3.Analyze | 4.Find | 5.Save | 6.Open | 7.Exit |");
            Console.WriteLine("+ ------------------------------------------------------------------+");
            //Class3 obj3 = new Class3(); //giong Java, ko tao duoc doi tuong tu abstract class !

            //ghi file => ghi csv(Comma Separated Value)
            //Quan ly package dung nuget(npm Nodejs, pom in Java, Gradle in Java)
            //Docker ?

            ////implicit casting = ep kieu tu dong
            ////Double y = x; //sure !
            ////Console.WriteLine("Hello World!");
            //////explicit casting = put a big thing inside a small box
            ////double x1 = 257;
            ////byte x2 = (byte)x1;//explicit, loss data
            ////Console.WriteLine("x2 = {0}", x2);
            ////Console.WriteLine("value - {0}", x1.ToString());
            ////boxing = don gian hoa pointer in C++
            //Int32 x = 100;
            //MyBox myBox = new MyBox() {
            //    Value = x
            //};
            //Program.doSomething(myBox);//value, ko phai dia chi
            //Console.WriteLine("x = {0}", myBox.Value); //tai sao ko = 120 ?
            //Ta muon no = 120, phai truyen vao "dia chi cua x"
            //C# don gian hon nhieu => boxing => goi bien x vao trong 1 doi tuong
            //khoi tao doi tuong tu class3:
            Class3Child obj1 = new Class3Child();
            Class3Child obj2 = new Class3Child();
            Class3Child obj3 = new Class3Child();            
            
            
            Console.WriteLine($"number of objects : {Class3Child.NumberOfObjects}");
            Class1 obj111 = new Class1();
            int x = 111;            
            obj111.method2(ref x);
            Console.WriteLine(x);
            ScreenA screenA = new ScreenA();
            ScreenB screenB = new ScreenB();
            screenB.Changed += new EventHandler(screenA.ListenEventFromB);
            screenB.Name = "Hoang";


        }
    }
}
