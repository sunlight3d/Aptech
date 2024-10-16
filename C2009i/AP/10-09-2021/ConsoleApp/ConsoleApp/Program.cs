using System;
//package trong Java
namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
            String name = "Hoang";
            int x = 10;
            int y = 20;
            //Console.WriteLine("name = "+name+", x = "+x);//string concatenation
            Console.WriteLine(x + y);
            var z = 120.0f;
            Console.WriteLine($"{x}{y}");
            Console.WriteLine($"name = {name}, x = {x}, y = {y}, z = {z}");//better
            //moi, kieu optional(co the null), khi nao hoc den object, class se de cap den
            String text = "Hello mr \"A\"";
            Console.WriteLine($"text = {text}");
            */
            Console.WriteLine($"sum = {Calculation.Sum2Numbers(2.0, 3.0)}");
            Console.WriteLine($"substract = {Calculation.Substract2Numbers(2.0, 3.0)}");
            Console.WriteLine($"rectangle\"s area = {Calculation.GetRectangleArea(2, 3)}");
            Console.WriteLine($"rectangle\"s area = {Calculation.GetRectangleArea(3, null)}");
            Console.WriteLine($"functionA : {Calculation.FunctionA(1, 2)}");
            Console.WriteLine($"functionA : {Calculation.FunctionA(2)}");

            Calculation.Sum2Numbers(x: 3, y: 4);//ok
            Calculation.Sum2Numbers(y: 4, x: 3);//ok, named/labelled parameters            
            //javascript
            //timestamp
            long t1 = DateTime.Now.Ticks / 100;
            for (int i = 0; i < 1_000; i++) {
                //Console.WriteLine($"step {i + 1}");
                Calculation.CalculateSomething(12.5);
            }
            long t2 = DateTime.Now.Ticks / 100;
            Console.WriteLine($"delta = {(t2 - t1)/1_000_000_000.0f} seconds");
            //timestamp
            //implicit casting
            int x = 10;
            float y = x; //ok, automatically

            double y1 = 100.0f;
            float y2 = (float)y1;//explicit casting
            for (long i = 0; i < 100; i++) {
                long t11 = DateTime.Now.Ticks / 100;
                long fn = Calculation.Fibonaci(i);
                long t22 = DateTime.Now.Ticks / 100;                
                Console.WriteLine($"Step {(i+1)}, value = {fn}, ");
                //Console.WriteLine($"time = {(t22 - t11) * 1_000_000_000.0f} seconds");
            }
        }
    }
}
