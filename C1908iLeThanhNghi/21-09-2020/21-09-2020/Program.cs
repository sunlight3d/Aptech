using System;

namespace _21_09_2020
{   
    class Program
    {
        static void doSomething() {
            Console.WriteLine("Do something");
            var myMoney = 123456L;
            Console.WriteLine("money = {0:C}", myMoney);
            Console.WriteLine("hex value = {0:X}", myMoney);
            //Conversion
            string y = "1213";
            var y1 = Convert.ToDouble(y);
            Console.WriteLine("hahah");
        }
        static void Main(string[] args)
        {
            float x = 100.0f;
            var y = 123.0;//Hieu la double
            Boolean isGood = true;
            Console.WriteLine("Gia tri cua x = {0}, y = {1}", x, y);
            Console.WriteLine("isGood = {0}", isGood);
            //Ternary = giong java 
            string status = isGood ? "Tot" : "Ko tot";            
            const double PI = 3.1416;
            Console.WriteLine("status = {0}", status);
            doSomething();
            Console.ReadLine();
        }
    }
}
