using System;
//namespace = package
namespace ConsoleApp
{    
    class Program
    {
        static void Main(string[] args)
        {
            int x = 10;
            int y = 20;
            string name = "Hoang";
            long creditCardNumber = 1234_5678_9101_1213;
            Console.WriteLine($"Value of x = {x}, y = {y}");
            Console.WriteLine("CreditCard number is : {0}, y = {1}, x = {2}", 
                creditCardNumber, y, x);
            Console.WriteLine("x = " + x + ", y = " + y);
            //string template = string concatenation
            Console.WriteLine($"name = ${name}");
            //float and double ?
            float a = 20.2f;
            double b = 22.11;
            Console.WriteLine("a = {0}, b = {1}", a, b);
            int sum = Program.Sum(2, 3);
            Console.WriteLine("sum 2 and 3 is : {0}", sum);
            int sum2 = Program.Sum(5, null);
            Console.WriteLine("sum2 : {0}", sum2);
            Console.WriteLine($"max value of int = {int.MaxValue}," +
                $" minvalue is : {int.MinValue}");
            int[] someNumbers = { 3, 4, 5, 6, -2, -4, 19 };
            int max = int.MinValue;
            foreach(int eachNumber in someNumbers)
            {
                max = (eachNumber > max) ? eachNumber : max;
            }
            /*
            for (int i = 0; i < someNumbers.Length; i++) {                
                max = (someNumbers[i] > max) ? someNumbers[i] : max;
            }
            */
            int age = 20;
            bool moneyIsImportant = age < 10 && age > 90;
            /*
            if (moneyIsImportant) { 

            }*/
           
            Console.WriteLine($"max = {max}");
        }
        static int Sum(int x, int? y) { //? = optional 
            return (int)(x + ((y == null) ? 0 : y));
        }
    }
}
