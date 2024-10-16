using System;
using System.Collections.Generic;
using practice1.namespace2;
namespace practice1.namespace1
{
    public class Class1
    {
        public void method1()
        {
            //Class3 object3 = new Class3(); //class thuoc namespace nay co the truy cap den class namespace khac neu la public, sure !
            //object3.prop3; //prop3 = private => NO !
            //object3.prop3 = "aaa"; //prop3 = protected => ko truy cap duoc, sub class moi truy cap duoc
            //object3.prop3 = "aaa";//prop3 = default => ko truy cap duoc

        }
        public void method2(ref int x) {
            x = 999;
            Dictionary<string, object> dictionary = new Dictionary<string, object>();
            dictionary.Add("name", "Hoang");
            dictionary.Add("age", 18);
            Dictionary<int, int> points = new Dictionary<int, int>();
            //points.Add(2, 3);
            points[2] = 3;
            points.Add(1, 4);
            
            points[2] = 99;
            Console.WriteLine("gaga");
            Console.WriteLine(points[2]);
            //toa do x, y
            //du lieu json

        }
        //overloading
        int sum(int x, int y) => x + y; //one-line function 
        float sum(float x, float y) => x + y;
        float sum(float x, float y, float z) => x + y + z;
        
    }
}
