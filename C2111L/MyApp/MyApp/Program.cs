
using System;
class Program {
    public static void FunctionA() {
        // See https://aka.ms/new-console-template for more information
        int x = 10;
        int y = 20;
        int sum = x + y;
        Console.WriteLine(sum);
        string firstName = "Nguyen";
        string lastName = "Van A";
        string fullName = firstName + lastName;
        Console.WriteLine($"My fullname is {fullName}");

        Console.WriteLine("Enter your name: ");
        string name = Console.ReadLine() ?? "";

        Console.WriteLine("Enter year of birth: ");
        int year = int.Parse(Console.ReadLine() ?? "2000");
        DateTime dateTime = DateTime.Now;

        Console.WriteLine($"Name : {name}, age : {dateTime.Year - year}");

        int marks = 6;
        string message = (marks <= 10 && marks >= 8) ? "Excellent" :
            (marks < 8 && marks >= 7) ? "Good" :
            (marks < 7 && marks >= 5) ? "Medium" :
            (marks < 5 && marks >= 3) ? "Bad" :
            (marks < 3 && marks >= 0) ? "So bad" : "Invalid value";
        Console.WriteLine(message);

    }
    public static void Main(string[] args)
    {
        int[] someNumbers = { 1, 33, 82, 4, 5, 6, 7, 6, 9 };
        /*
        for (int i = 0; i < someNumbers.Length; i++) { 
            Console.WriteLine(someNumbers[i]);
        }
        */
        /*
        foreach(var item in someNumbers) { 
            if(item is int)
            {
                Console.Write($"{item}, ");
            }            
        }
        */
        for (int j = someNumbers.Length - 1; j >= 0; j--)        {
            Console.WriteLine(someNumbers[j]);
        }
        int x = 0;
        int y = 1;
        int z = x+y; //lombok
       
    }
}