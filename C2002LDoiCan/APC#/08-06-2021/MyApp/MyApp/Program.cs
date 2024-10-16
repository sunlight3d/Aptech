using System;

namespace MyApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var x = 100;// gia tri ban dau tu dinh kieu
            if (x is Int32) {
                Console.WriteLine("This is an integer");
            }
            String name = "Hoang";
            int age = 18; //primitive
            //string concatenation
            Console.WriteLine("x = {0}, name = {1}", x, name);
            //Float va Double => giong Java
            float y = 1.2f;
            double z = 2.3;
            var yy = y + z;
            Console.WriteLine("yy = {0}", yy);
            //Unicode => hien data kieu dang icon
            Console.WriteLine("\u2665");
        }
    }
}
