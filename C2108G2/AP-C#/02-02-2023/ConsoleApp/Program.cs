//namespace = "package in Java"
using ConsoleApp.Models; //import in Java
using System.Diagnostics.CodeAnalysis;

namespace ConsoleApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int x = 10;
            float y = 20;
            var z = 124f;
            Console.WriteLine("Value of x is : " + x);//string concatenation
            Console.WriteLine($"Value of y is: {y}");
            Console.WriteLine($"y = {y}, z = {z}");
            int a = 10;
            int b = a;//assignment
            //int* b = &a;//C         
            //*b //C
            a = 20;
            //b = ?
            Console.WriteLine($"b = {b}");
            //what is "reference"
            //initialize 2 objects
            //Point p1 = new Point(1, 1);//java style
            Point p1 = new Point //c# style
            {
                Y = 2,//labeled arguments, Java unavailable!
                X = 1
            }; //in Java, we can use "Builder Pattern"
            //Point p2 = new Point(2, 2);//java style
            Point p2 = new Point //c# style
            {
                X = 3,
                Y = 4
            };
            Console.WriteLine(p1);
            Console.WriteLine(p2);
            Point p3 = p1;//reference, not assignment
            Point p4 = p1;//reference
            //test assignment
            //p1.setX(200);
            p1.X = 200;//setter
            //p3.x = ? 
            //p1 = null;
            //p3 = null;
            //Console.WriteLine("p3.x is : " + p3.getX());
            Console.WriteLine("p4.x is : " + p4.X);//getter
            Console.WriteLine("Please enter your name");
            string name = Console.ReadLine() ?? ""; //?? = default value
            Console.WriteLine($"You entered {name}");
            StringUtility stringUtility = new StringUtility();
            Console.WriteLine($"There are {stringUtility.CountWord(name)} words in this name");

            List<Student> students = new List<Student>();
            for (int i = 0; i < 2; i++) { 
                Student student = new Student();
                student.Input();
                students.Add(student);
            }
            foreach(var student in students) {
                Console.WriteLine(student);
            }

            Console.WriteLine("haha");
        }
    }
}