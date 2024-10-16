using ConsoleApp.Models;
using ConsoleApp.Utilities;

namespace ConsoleApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int x = 100;
            string name = "Hoang";
            var y = 123;
            Console.WriteLine($"x = {x}, name = {name}, y = {y}");
            var sumResult = Calculation.Sum(2, 3);
            Console.WriteLine(sumResult);
            Console.WriteLine($"Value sum of 3 numbers : {Calculation.Sum(1, 4, 5)}");
            //Calculation.SayHello("Hoang");
            Calculation.SayHello(null);
            Calculation.Display(                
                message : "I love my work",
                color: "red"//labeled arguments
            );
            Rectangle rect1 = new Rectangle { 
                Height= 2_000_000,
                Width = 3_000_000,
            };
            /*
            rect1.Width = 100;
            rect1.Height = 200;
            */
            Console.WriteLine (rect1);
            Console.WriteLine($"area of rect1 is: {rect1.Area()}");
            Console.WriteLine("haha "+3+4);
            Console.WriteLine(rect1.Perimeter());
            Console.WriteLine("\u274b");
            Console.Write("Please enter a number: ");
            double xx = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine($"You entered : {xx}");
            Student studentA = new Student();//no-args constructor
            Student studentB = new Student //all-args constructor
            {
                Address = "somewhere",
                RollNumber = "12345X",
                Name="Nguyen Duc Hoang",                
                Age = 18
            };//Builder pattern in Java 

            List<Student> students = new List<Student>();
        }
    }
}